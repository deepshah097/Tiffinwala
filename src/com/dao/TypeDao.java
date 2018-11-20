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
import com.vo.TypeVo;
@Repository
public class TypeDao {


	@Autowired
	SessionFactory sessionFactory;
	
	public void save(TypeVo typevo)
	{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(typevo);
		tr.commit();
		session.close();
	}
	
	
	public List search()
	{
		List typelist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from TypeVo");
			   typelist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return typelist;
		
	}
	
	
	public List edit(TypeVo cvo)
	{
		List ls=new ArrayList();
		try{
			Session session=sessionFactory.openSession();
			Query q=session.createQuery("from TypeVo where id='"+cvo.getType_id()+"'");
			ls=q.list();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;	
	}
	
	public List update(TypeVo cvo1)
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
	
	public List delete(TypeVo cvo2)
	{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(cvo2);
		tr.commit();
		session.close();
		return null;
		
	}

	
}
