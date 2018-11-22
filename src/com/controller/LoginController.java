package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.OrderDao;
import com.dao.TiffinDao;
import com.dao.UserDao;
import com.mysql.fabric.Response;
import com.vo.CityVo;
import com.vo.TiffinVo;
import com.vo.UserVo;

@Controller
public class LoginController {

	@Autowired
	UserDao userdao;
	@Autowired
	TiffinDao tiffindao;
	@Autowired
	OrderDao orderdao;
	
	
	@RequestMapping(value="/loginpage.htm",method=RequestMethod.GET)
	public String showloginpage() {
		return("Login");
	}
	
	@RequestMapping(value="/indextiffinwala.htm",method=RequestMethod.GET)
	public ModelAndView showtiffinwalapage(@RequestParam("id")int id) {
		List orderlist=new ArrayList();
		List tiffinlist=new ArrayList();
		tiffinlist=this.tiffindao.search(id);
		TiffinVo t=(TiffinVo)tiffinlist.get(0);
		orderlist=this.orderdao.searchpendingorder(t.getTiffin_id());
		return new ModelAndView("tiffinwalaindex","orderlist",orderlist);
//		return("tiffinwalaindex");
	}
	
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public ModelAndView Login(HttpServletRequest req,HttpServletResponse res,HttpSession session)
	{
		
		String username=req.getParameter("username");
		String userpass=req.getParameter("password");
		
		List userlist=new ArrayList();
		userlist=this.userdao.search();
		for(int i=0;i<userlist.size();i++) {
			UserVo uservo=(UserVo) userlist.get(i);
			if(username.equals(uservo.getUser_email()) && userpass.equals(uservo.getUser_password())){
				if(uservo.getUser_flag()==1) {
				session=req.getSession();
				session.setAttribute("user", uservo);	
				return new ModelAndView("redirect:/index.htm");	
				}
				else if(uservo.getUser_flag()==2) {
					session=req.getSession();
					session.setAttribute("user", uservo);	
					return new ModelAndView("redirect:/indextiffinwala.htm","id",uservo.getUser_id());	
					}
				else if(uservo.getUser_flag()==3) {
					req.setAttribute("loginError", "You will be Authenticate soon...");
					return new ModelAndView("Login","loginError","You will be Authenticate soon...");					
					}
				
				
				else {
					req.setAttribute("loginError", "Enter valid Username and Password");
					return new ModelAndView("Login","loginError","Enter valid Username and Password");
				}
			}
			
		}
		req.setAttribute("loginError", "Enter valid Username and Password");
		return new ModelAndView("Login","loginError","Enter valid Username and Password");
		
		
	
	}
	
	@RequestMapping(value="/signup.htm",method=RequestMethod.POST)
	public String inserttiffin(HttpServletRequest req,HttpServletResponse res)
	
	{
		String email=req.getParameter("tiffinemail");
		String address=req.getParameter("tiffinaddress");
		String mobile=req.getParameter("tiffinnumber");
		String name=req.getParameter("tiffinname");
		int pincode=Integer.parseInt(req.getParameter("tiffinpincode"));
		int city=Integer.parseInt(req.getParameter("tiffincity"));
		int userid=Integer.parseInt(req.getParameter("uservo_user_id"));
		
		CityVo cvo=new CityVo();
		cvo.setCity_id(city);
		UserVo uvo=new UserVo();
		uvo.setUser_id(userid);
		TiffinVo vo1=new TiffinVo();
		vo1.setTiffin_email(email);
		vo1.setTiffin_address(address);
		vo1.setCityvo(cvo);
		vo1.setTiffin_flag(0);
		vo1.setTiffin_mobile(mobile);
		vo1.setTiffin_name(name);
		vo1.setTiffin_pincode(pincode);
		vo1.setUservo(uvo);
		vo1.setImage(" ");
		this.tiffindao.save(vo1); 
		  System.out.println("savedddddddddddddddd");
		  return "massagepage";
//		return new ModelAndView("redirect:loginpage.htm");
	} 
	
	@RequestMapping(value="/logout.htm",method=RequestMethod.GET)
	public String showlogout(HttpServletRequest req,HttpServletResponse res) {
		
		HttpSession session=req.getSession();
		res.setHeader("Pragma", "no-cache");
		res.setHeader("Cache-Control", "no-store");
		res.setHeader("Expires", "0");
		res.setDateHeader("Expires", -1);
		session.invalidate();
		return("Login");
	}
	
	
}
