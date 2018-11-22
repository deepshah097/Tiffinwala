package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CityDao;
import com.dao.MenuDao;
import com.dao.OrderDao;
import com.dao.TiffinDao;
import com.vo.OrderVo;
import com.vo.TiffinVo;

@Controller
public class OrderController {

	@Autowired
	OrderDao orderdao;
	
	@Autowired
	CityDao citydao;
	
	@Autowired
	TiffinDao tiffindao;
	
	@Autowired
	MenuDao menudao;
	
	
	@RequestMapping(value="/addorder.htm",method=RequestMethod.GET)
	public ModelAndView loadtiffin(@ModelAttribute OrderVo vo)
	{
		List ls=this.tiffindao.search();
		List ls1=this.citydao.search();
		List ls2=this.menudao.search();
		return new ModelAndView("addorder","order",new OrderVo()).addObject("citylist",ls1).addObject("menulist", ls2).addObject("tiffinlist",ls);
	}
	
	
	@RequestMapping(value="/insertorder.htm",method=RequestMethod.POST)
	public ModelAndView inserttiffin(@ModelAttribute OrderVo vo)
	
	{
		  this.orderdao.save(vo);    
		return new ModelAndView("redirect:ViewOrder.htm");
		
	}  
	
	
	@RequestMapping(value="/ViewOrder.htm",method=RequestMethod.GET)
	public ModelAndView showtiffin(@RequestParam("id")int id)
	{
		
		List orderlist=new ArrayList();
		List tiffinlist=new ArrayList();
		tiffinlist=this.tiffindao.search(id);
		TiffinVo t=(TiffinVo)tiffinlist.get(0);
		orderlist=this.orderdao.search(t.getTiffin_id());
		return new ModelAndView("ViewOrder","orderlist",orderlist);
	}
	
	//tiffinwalacode
	
	@RequestMapping(value="/Viewpastorders.htm",method=RequestMethod.GET)
	public ModelAndView viewpastorders(@RequestParam("id")int id)
	
	{
		//System.out.println("updated"+);
//		List orderlist=new ArrayList();
//		orderlist=this.orderdao.viewpastorder(id);
		List orderlist=new ArrayList();
		List tiffinlist=new ArrayList();
		tiffinlist=this.tiffindao.search(id);
		TiffinVo t=(TiffinVo)tiffinlist.get(0);
		orderlist=this.orderdao.searchpastorder(t.getTiffin_id());
		return new ModelAndView("ViewPastOrder","orderlist",orderlist);
		
	}  
	
	@RequestMapping(value="/Viewpendingorder.htm",method=RequestMethod.GET)
	public ModelAndView viewpendingorders(@RequestParam("id")int id)
	
	{
	
		List orderlist=new ArrayList();
		List tiffinlist=new ArrayList();
		tiffinlist=this.tiffindao.search(id);
		TiffinVo t=(TiffinVo)tiffinlist.get(0);
		orderlist=this.orderdao.searchpendingorder(t.getTiffin_id());
		return new ModelAndView("ViewPendingOrder","orderlist",orderlist).addObject("idd", id);
		
	}
	
	@RequestMapping(value="/approvependingorder.htm",method=RequestMethod.GET)
	public ModelAndView approvependingorders(@RequestParam("id")int id,@RequestParam("tid1")int tid)
	
	{
		//System.out.println("updated"+);
//		List orderlist=new ArrayList();
//		orderlist=this.orderdao.viewpastorder(id);
		List orderlist=new ArrayList();
		int orderlist1=this.orderdao.updatependingorderflag(id);
		System.out.println("approved..........   "+orderlist1);
		System.out.println("-------------------"+tid);
		return new ModelAndView("redirect:/Viewpendingorder.htm?id="+tid);
		
	}
	
	@RequestMapping(value="/disapprovependingorder.htm",method=RequestMethod.GET)
	public ModelAndView disapprovependingorders(@RequestParam("id")int id,@RequestParam("tid1")int tid)
	
	{
		//System.out.println("updated"+);
//		List orderlist=new ArrayList();
//		orderlist=this.orderdao.viewpastorder(id);
		List orderlist=new ArrayList();
		int orderlist1=this.orderdao.updatedispendingorderflag(id);
		System.out.println("approved..........   "+orderlist1);
		return new ModelAndView("redirect:/Viewpendingorder.htm?id="+tid);
		
	}
	
}
