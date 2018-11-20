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
import com.vo.CityVo;

@Controller
public class CityController {
	
	@Autowired
	CityDao citydao;
	
	@RequestMapping(value="/addCity.htm",method=RequestMethod.GET)
	public ModelAndView adduser()
	{
		return new ModelAndView("addcity","vo",new CityVo());
		
	}
	
	@RequestMapping(value="/savecity.htm",method=RequestMethod.POST)
	public ModelAndView save4(@ModelAttribute CityVo vo)
	{
		this.citydao.save(vo);
		return new ModelAndView("redirect:/ViewCity.htm");
		
	}
	
	@RequestMapping(value="/ViewCity.htm",method=RequestMethod.GET)
	public ModelAndView showstudent()
	{
		List citylist=new ArrayList();
		citylist=this.citydao.search();
		return new ModelAndView("ViewCity","citylist",citylist);
	}
	
	
	
	@RequestMapping(value="EditCity.htm",method=RequestMethod.GET)
	public ModelAndView editeStudent(@RequestParam("id")int i)
	{
		
		CityVo cityVo=new CityVo();
		cityVo.setCity_id(i);
		List ls=citydao.edit(cityVo);
		return new ModelAndView("EditCity","v1",(CityVo)ls.get(0));
		
		}
	@RequestMapping(value="/updateCity.htm",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute CityVo vo)
	{
		this.citydao.update(vo);
		return new ModelAndView("redirect:/ViewCity.htm");
	}
	
	
	
	
	
	
	@RequestMapping(value="deleteCity",method=RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute CityVo vo,@RequestParam("id") int id)
	{
		vo.setCity_id(id);
		this.citydao.delete(vo);
		
		return new ModelAndView("redirect:/ViewCity.htm");
		
	}
	
	
	
}
