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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CityDao;
import com.dao.TiffinDao;
import com.dao.TypeDao;
import com.dao.UserDao;
import com.mysql.fabric.Response;
import com.vo.UserVo;

@Controller

public class AuthenticationController {

	@Autowired
	UserDao userdao;
	@Autowired
	TiffinDao tiffindao;
	@Autowired
	TypeDao typedao;
	@Autowired
	CityDao citydao;
	
//	@RequestMapping(value="/loginpage.htm",method=RequestMethod.GET)
//	public String showloginpage() {
//		return("Login");
//	}
	
	
	@RequestMapping(value="/authenticate.htm",method=RequestMethod.POST)
	public String Login(HttpServletRequest req,HttpServletResponse res,HttpSession session)
	{
		
		String username=req.getParameter("username");
		
		List userlist=new ArrayList();
		userlist=this.userdao.search();
//		List tiffinwalauserlist=new ArrayList();
		
		for(int i=0;i<userlist.size();i++) {
			UserVo uservo=(UserVo) userlist.get(i);
			if(username.equals(uservo.getUser_email())){
				if(uservo.getUser_flag()==3) {
					List tiffinwalauserlist=this.tiffindao.search(uservo.getUser_id());
					System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$        "+tiffinwalauserlist);
					
					if(tiffinwalauserlist.size()<=0) {
						List citylist=this.citydao.search();
						session=req.getSession();
						session.setAttribute("user", uservo);
						session.setAttribute("citylist",citylist);
						return ("Signup");
					}
					else {
						req.setAttribute("loginError", "Sorry! You are Already Exist");
						return("Authenticate");
					}
				}
			}
			
		}
		req.setAttribute("loginError", "Enter valid Email ID");
		return("Authenticate");
		
		
	
	}
	
//	@RequestMapping(value="/logout.htm",method=RequestMethod.GET)
//	public String showlogout(HttpServletRequest req,HttpServletResponse res) {
//		
//		HttpSession session=req.getSession();
//		res.setHeader("Pragma", "no-cache");
//		res.setHeader("Cache-Control", "no-store");
//		res.setHeader("Expires", "0");
//		res.setDateHeader("Expires", -1);
//		session.invalidate();
//		return("Login");
//	}
//	
	
}
