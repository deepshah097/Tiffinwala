package com.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.MenuDao;
import com.dao.TiffinDao;
import com.dao.TypeDao;
import com.vo.MenuVo;
import com.vo.TiffinVo;
import com.vo.TypeVo;

@Controller

public class MenuController {

	@Autowired
	MenuDao menudao;
	@Autowired
	TypeDao typedao;
	@Autowired
	TiffinDao tiffindao;
	
	@RequestMapping(value="/addmenu.htm",method=RequestMethod.GET)
	public String loadtiffin(@RequestParam("id") int id,HttpServletRequest req,HttpSession session)
	{
		List ls=this.typedao.search();
		List ls1=this.tiffindao.search(id);
		TiffinVo t=(TiffinVo)ls1.get(0);
		session=req.getSession();
		session.setAttribute("tid", t.getTiffin_id());
		session.setAttribute("typelist", ls);
		System.out.println("0000000000000000000000000000000000000000000       "+t.getTiffin_id());
		return "addmenu";
	}
	
	@RequestMapping(value="/savemenu.htm",method=RequestMethod.POST)
	public String save4(HttpServletRequest req)
	{
		String menuitem=req.getParameter("menuitems");
		int price=Integer.parseInt(req.getParameter("menuprice"));
		String desc=req.getParameter("menudesc");
		int type=Integer.parseInt(req.getParameter("menutype"));
		int id=Integer.parseInt(req.getParameter("tiffinvo_tiffin_id"));
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&         "+menuitem);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&         "+price);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&         "+desc);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&         "+type);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&         "+id);
		MenuVo vo=new MenuVo();
		vo.setMenu_desc(desc);
		vo.setMenu_items(menuitem);
		vo.setMenu_price(price);
		TypeVo tvo=new TypeVo();
		tvo.setType_id(type);
		vo.setTypevo(tvo);
		vo.setCurrent(1);
		TiffinVo tiffinvo=new TiffinVo();
		tiffinvo.setTiffin_id(id);
		vo.setTiffinvo(tiffinvo);
		
		this.menudao.save(vo);
		return "redirect:/ViewCurrentMenu.htm?id="+id;
		
	}	
	@RequestMapping(value="/ViewPastMenu.htm",method=RequestMethod.GET)
	public ModelAndView showpastmenu(@RequestParam("id")int i)
	{
		System.out.println("View Past Menu called");
		List menulist=new ArrayList();
		menulist=this.menudao.searchbypastmenu(i);
		return new ModelAndView("viewpastmenu","menulist",menulist);
	}
	@RequestMapping(value="/ViewCurrentMenu.htm",method=RequestMethod.GET)
	public ModelAndView showcurentmenu(@RequestParam("id")int i)
	{
		System.out.println("i=   "+i);
		List menulist=new ArrayList();
		menulist=this.menudao.searchbycurrentmenu(i);
		return new ModelAndView("viewmenu","menulist",menulist);
	}
	
	@RequestMapping(value="/approvemenucurrent.htm",method=RequestMethod.GET)
	public ModelAndView updatemenuflag(@RequestParam("id")int id,@RequestParam("tid1")int tid)
	
	{
		System.out.println("id is:"+id); 
		System.out.println("updated"+this.menudao.approvemenuflag(id));	
		return new ModelAndView("redirect:/ViewCurrentMenu.htm?id="+tid);
		
	}
	
	
	@RequestMapping(value="EditMenu.htm",method=RequestMethod.GET)
	public ModelAndView editeStudent(@RequestParam("id")int i,@RequestParam("tid")int tid)
	{
		
		MenuVo menuVo=new MenuVo();
		TiffinVo tiffinvo=new TiffinVo();
		tiffinvo.setTiffin_id(tid);
		List ls1=this.typedao.search();
		menuVo.setMenu_id(i);
		menuVo.setTiffinvo(tiffinvo);
		List ls=menudao.edit(menuVo);
		return new ModelAndView("EditMenu","v1",(MenuVo)ls.get(0)).addObject("typelist", ls1);
		
		}
	@RequestMapping(value="/updateMenu.htm",method=RequestMethod.POST)
	public String update(@ModelAttribute MenuVo vo)
	{
		this.menudao.update(vo);
		return "tiffinwalaindex";
	}
	
	
	
	
	
	
	@RequestMapping(value="deletemenu",method=RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute MenuVo vo,@RequestParam("id") int id)
	{
		vo.setMenu_id(id);
		this.menudao.delete(vo);
		
		return new ModelAndView("redirect:/ViewMenu.htm");
		
	}
	
	
	
}
