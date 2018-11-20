package com.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
import com.vo.TiffinVo;
import com.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	UserDao userdao;
	@Autowired
	TiffinDao tiffindao;
	@Autowired
	OrderDao orderdao;
	
	@RequestMapping(value="/addUser.htm",method=RequestMethod.GET)
	public ModelAndView adduser()
	{
		return new ModelAndView("adduser","vo",new UserVo());
		
	}
	
	@RequestMapping(value="/addAdmin.htm",method=RequestMethod.GET)
	public ModelAndView addadmin()
	{
		return new ModelAndView("addadmin","vo",new UserVo());
		
	}
	@RequestMapping(value="/saveadmin.htm",method=RequestMethod.POST)
	public ModelAndView saveadmin(@ModelAttribute UserVo vo)
	{
		this.userdao.save(vo);
		return new ModelAndView("redirect:/index.htm");
		
	}
	
	@RequestMapping(value="/saveuser.htm",method=RequestMethod.POST)
	public ModelAndView save4(@ModelAttribute UserVo vo)
	{
		this.userdao.save(vo);
		return new ModelAndView("redirect:/ViewUser.htm");
		
	}
	
	@RequestMapping(value="/ViewUser.htm",method=RequestMethod.GET)
	public ModelAndView showstudent()
	{
		List userlist=new ArrayList();
		userlist=this.userdao.search();
		return new ModelAndView("ViewUser","userlist",userlist);
	}
	
	
	
	@RequestMapping(value="/Viewdisapprovetiffinwala.htm",method=RequestMethod.GET)
	public ModelAndView showuserbyflag()
	{
		List userlist=new ArrayList();
		userlist=this.userdao.searchbyuserflag();
		return new ModelAndView("DisapproveTiffinwala","tiffinlist",userlist);
	}
	
	@RequestMapping(value="/index.htm",method=RequestMethod.GET)
	public ModelAndView welcome(HttpServletRequest req)
	{
		int userlist=this.userdao.countactiveuser();
		int tiffinlist=this.userdao.countactivetiffinwala();
		int cntpending=this.tiffindao.countpendingtiffinwala();
		List userlist1=new ArrayList();
		userlist1=this.userdao.searchbypendingtiffinwala();
		req.setAttribute("cnt", cntpending);
		return new ModelAndView("index","useractivelist",userlist).addObject("activetiffin",tiffinlist).addObject("tiffinlist",userlist1);
	}
	
	
	@RequestMapping(value="/tiffinwalaindex.htm",method=RequestMethod.GET)
	public ModelAndView welcometiffinwala(@RequestParam("id")int id)
	{
		List tid1=this.tiffindao.returntiffinwalaid(id);
		TiffinVo tid=(TiffinVo)tid1.get(0);
		System.out.println("heloooooooo-----------------"+tid);
		List userlist=new ArrayList();
		userlist=this.orderdao.returnpandingorders(tid.getTiffin_id());
		System.out.println("--------------oyyyyy------------------------");
		List orderlist=new ArrayList();
		List tiffinlist=new ArrayList();
		tiffinlist=this.tiffindao.search(id);
		TiffinVo t=(TiffinVo)tiffinlist.get(0);
		orderlist=this.orderdao.searchpendingorder(t.getTiffin_id());
		return new ModelAndView("tiffinwalaindex","pandinglist",userlist).addObject("orderlist", orderlist);
	}
	
	
	@RequestMapping(value="/Viewapprovetiffinwala.htm",method=RequestMethod.GET)
	public ModelAndView showapprovetiffinwala()
	{
		List userlist=new ArrayList();
		userlist=this.userdao.searchbyactivetiffinwala();
		return new ModelAndView("ActiveTiffinwala","tiffinlist",userlist);
	}
	
	
	@RequestMapping(value="/Viewalluser.htm",method=RequestMethod.GET)
	public ModelAndView showalluser()
	{
		List userlist=new ArrayList();
		userlist=this.userdao.searchbyactiveusers();
		return new ModelAndView("ViewUser","userlist",userlist);
	}
	
	@RequestMapping(value="/Viewpendingtiffinwala.htm",method=RequestMethod.GET)
	public ModelAndView showpendingtiffinwala()
	{
		List userlist=new ArrayList();
		userlist=this.userdao.searchbypendingtiffinwala();
		return new ModelAndView("PendingTiffinwala","tiffinlist",userlist);
	}
	
	@RequestMapping(value="/updatetiffinwala2.htm",method=RequestMethod.GET)
	public String uodatetiffin(@RequestParam("id")int id)
	
	{
		System.out.println("id is:"+id); 
		System.out.println("updated"+this.userdao.updateflag(id));
		return "updatetiffinwala2";
		
	}
	
	
	@RequestMapping(value="/changepassredirect.htm",method=RequestMethod.GET)
	public ModelAndView changepassredirect()
	
	{
		
		return new ModelAndView("changepassword");
		
	}
	
	
	
	
	@RequestMapping(value="/changepassword.htm",method=RequestMethod.POST)
	public String changepassword(@RequestParam("id")int id,@RequestParam("oldpass")String oldpass,@RequestParam("newpass")String newpass,@RequestParam("repass")String repass,HttpServletRequest req,HttpServletResponse res)
	
	{
		UserVo uservo1 = null;
		System.out.println("helllooooo"+id+" old "+oldpass+"  "+newpass);
		List userlist1=new ArrayList();
		userlist1=this.userdao.searchbyuserid(id);
		for(int j=0;j<userlist1.size();j++) {
			 uservo1=(UserVo) userlist1.get(j);
			 
			 
		}
		//System.out.println("hello"+uservo1.getUser_password());
		
		if(oldpass.equals(""+uservo1.getUser_password())) {
			
		System.out.println("hello");
		
				if(newpass.equals(""+repass)) {
					
					int a=this.userdao.updatepass(newpass, id);
					System.out.println("aaaa"+a);
					
					if(a>0) {
						return "tiffinwalaindex";
						//System.out.println("success");
						
					}
					else {
						
						System.out.println("fail");
					}
					
				}else {
					
					req.setAttribute("newpass", "Something went wrong please re-enter password");
					System.out.println("Check your password!!");
					return "changepassword";
					
				}
		
		}else {
			req.setAttribute("oldpass", "Something went wrong please re-enter password");
			System.out.println("Check our old password!!");
			return "changepassword";
		}
		
		return null;
		
	}
	

	
	
}
