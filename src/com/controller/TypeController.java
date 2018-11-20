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

import com.dao.TypeDao;
import com.vo.TypeVo;

@Controller
public class TypeController {

	@Autowired
	TypeDao typedao;
	
	
	@RequestMapping(value="/addType.htm",method=RequestMethod.GET)
	public ModelAndView adduser()
	{
		return new ModelAndView("addType","vo",new TypeVo());
		
	}
	
	@RequestMapping(value="/saveType.htm",method=RequestMethod.POST)
	public ModelAndView save4(@ModelAttribute TypeVo vo)
	{
		this.typedao.save(vo);
		return new ModelAndView("redirect:/ViewType.htm");
		
	}
	
	@RequestMapping(value="/ViewType.htm",method=RequestMethod.GET)
	public ModelAndView showstudent()
	{
		List typelist=new ArrayList();
		typelist=this.typedao.search();
		return new ModelAndView("ViewType","typelist",typelist);
	}
	
	
	@RequestMapping(value="EditType.htm",method=RequestMethod.GET)
	public ModelAndView editeStudent(@RequestParam("id")int i)
	{
		
		TypeVo typeVo=new TypeVo();
		typeVo.setType_id(i);
		List ls=typedao.edit(typeVo);
		return new ModelAndView("EditType","v1",(TypeVo)ls.get(0));
		
		}
	@RequestMapping(value="/updateType.htm",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute TypeVo vo)
	{
		this.typedao.update(vo);
		return new ModelAndView("redirect:/ViewType.htm");
	}
	
	
	
	
	
	
	@RequestMapping(value="deleteType",method=RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute TypeVo vo,@RequestParam("id") int id)
	{
		vo.setType_id(id);
		this.typedao.delete(vo);
		
		return new ModelAndView("redirect:/ViewType.htm");
		
	}
	

}
