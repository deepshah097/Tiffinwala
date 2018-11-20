package com.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.CityVo;
@Repository

public class CityDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(CityVo cityvo)
	{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(cityvo);
		tr.commit();
		session.close();
	}
	
	
	public List search()
	{
		List studentlist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from CityVo");
			   studentlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return studentlist;
		
	}
	
	
	public List edit(CityVo cvo)
	{
		List ls=new ArrayList();
		try{
			Session session=sessionFactory.openSession();
			Query q=session.createQuery("from CityVo where id='"+cvo.getCity_id()+"'");
			ls=q.list();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;	
	}
	
	public List update(CityVo cvo1)
	{
		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.update(cvo1);
			transaction.commit();
			session.close();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		}
	
	public List delete(CityVo cvo2)
	{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(cvo2);
		tr.commit();
		session.close();
		return null;
		
	}

	
}
