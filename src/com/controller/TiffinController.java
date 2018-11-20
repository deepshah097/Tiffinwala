package com.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CityDao;
import com.dao.OrderDao;
import com.dao.TiffinDao;
import com.dao.UserDao;
import com.vo.OrderVo;
import com.vo.TiffinVo;
import com.vo.UserVo;

@Controller

public class TiffinController {

	@Autowired
	TiffinDao tiffindao;
	@Autowired
	CityDao citydao;
	@Autowired
	UserDao userdao;
	@Autowired
	OrderDao oderdao;
	
	@RequestMapping(value="/addTiffinwala.htm",method=RequestMethod.GET)
	public ModelAndView loadtiffin(@ModelAttribute TiffinVo vo,@RequestParam("id")int id,HttpServletRequest req)
	{
//		List ls=this.userdao.search();
		req.setAttribute("user_id", id);
		List ls1=this.citydao.search();
		return new ModelAndView("addtiffinwala","tiffindata",new TiffinVo()).addObject("citylist",ls1);
	}
	
	@RequestMapping(value="/inserttiffinwala.htm",method=RequestMethod.POST)
	public ModelAndView inserttiffin(@ModelAttribute TiffinVo vo)
	
	{
		  this.tiffindao.save(vo); 
		  
		return new ModelAndView("redirect:ViewTiffin.htm");
		
	}  
	
	@RequestMapping(value="/approveflag.htm",method=RequestMethod.GET)
	public ModelAndView uodatetiffin(@RequestParam("id")int id,@RequestParam("user_id")int user_id)
	
	{
		System.out.println("id is:"+id); 
		System.out.println("updated"+this.tiffindao.approvetiffinflag(id));
		
		System.out.println("updated"+this.userdao.updateflag(user_id));
		return new ModelAndView("redirect:index.htm");
		
	}
	
	@RequestMapping(value="/disapproveflag.htm",method=RequestMethod.GET)
	public ModelAndView disapprovetiffin(@RequestParam("id")int id,@RequestParam("user_id")int user_id)
	
	{
		System.out.println("id is:"+id); 
		System.out.println("updated"+this.tiffindao.disapprovetiffinflag(id));
		System.out.println("updated"+this.userdao.updatedisapproveflag(user_id));
		return new ModelAndView("redirect:index.htm");
		
	}
	
	@RequestMapping(value="/ViewTiffin.htm",method=RequestMethod.GET)
	public ModelAndView showtiffin()
	{
		
		List tiffinlist=new ArrayList();
		tiffinlist=this.tiffindao.search();
		return new ModelAndView("ViewTiffin","tiffinlist",tiffinlist);
	}
	
	
//	tiffinwala code started
	
	@RequestMapping(value="/Viewpendingorders.htm",method=RequestMethod.GET)
	public ModelAndView showpendingtiffinwala(@RequestParam("id")int id)
	{
		List orderlist=new ArrayList();
		List tiffinlist=new ArrayList();
		List resultorder=new ArrayList();
		orderlist=this.tiffindao.searchbypendingorder();
		for(int i=0;i<orderlist.size();i++) {
			OrderVo ordervo=(OrderVo) orderlist.get(i);
			System.out.println("order vo. user id"+ordervo.getTiffinvo().getUservo().getUser_id());
			if(ordervo.getTiffinvo().getUservo().getUser_id()==id) {
				System.out.println("+++++++++"+ordervo.getTiffinvo().getUservo().getUser_id());
				tiffinlist=this.tiffindao.searchbypendinglistorder(ordervo.getTiffinvo().getUservo().getUser_id());
				System.out.println(tiffinlist);
				for(int j=0;j<tiffinlist.size();j++) {
					TiffinVo tiffinvo=(TiffinVo) tiffinlist.get(i);
					System.out.println("--------"+tiffinvo.getTiffin_id());
					resultorder=this.oderdao.searchorder(tiffinvo.getTiffin_id());
				
			}
		}
			else {
				break;
			}
		}
		return new ModelAndView("pendingorder","orderlist",resultorder);
	}
	
	
}

