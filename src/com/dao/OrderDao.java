package com.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;  
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.OrderVo;

@Repository

public class OrderDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void save(OrderVo ordervo)
	{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(ordervo);
		tr.commit();
		session.close();
	}
	
	
	public List search()
	{
		List orderlist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from OrderVo");
			   orderlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return orderlist;
		
	}

	public List search(int id)
	{
		List orderlist=new ArrayList();
		try{
			Date d=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		    String strDate= formatter.format(d);  
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from OrderVo where tiffinvo_tiffin_id=:id and date=:strDate and order_flag=0");
			  q.setParameter("strDate", strDate);
			  q.setParameter("id", id);
			   orderlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return orderlist;
		
	}
	public List searchpastorder(int id)
	{
		List orderlist=new ArrayList();
		try{
			Date d=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		    String strDate= formatter.format(d);  
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from OrderVo where tiffinvo_tiffin_id=:id and date!=:strDate and order_flag=0");
			  q.setParameter("id", id);
			  q.setParameter("strDate", strDate);
			   orderlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return orderlist;
		
	}
	
	public List searchpendingorder(int id)
	{
		List orderlist=new ArrayList();
		try{
			Date d=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		    String strDate= formatter.format(d);  
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from OrderVo where tiffinvo_tiffin_id=:id and date=:strDate and order_flag=1");
			  q.setParameter("id", id);
			  q.setParameter("strDate", strDate);
			   orderlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return orderlist;
		
	}
	
	
	public List edit(OrderVo cvo)
	{
		List ls=new ArrayList();
		try{
			Session session=sessionFactory.openSession();
			Query q=session.createQuery("from OrderVo where id='"+cvo.getOrder_id()+"'");
			ls=q.list();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;	
	}
	
	public int updatependingorderflag(int id)
	{
		List userlist=new ArrayList();
		
		try{
			 Session session=sessionFactory.openSession();
			
			 
			Query query = session.createQuery("update OrderVo set order_flag=0 where order_id=:id");
			query.setParameter("id", id);
			int result = query.executeUpdate();
			   session.close();		
		  return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return 0;
		
	}
	
	public int updatedispendingorderflag(int id)
	{
		List userlist=new ArrayList();
		
		try{
			 Session session=sessionFactory.openSession();
			
			 
			Query query = session.createQuery("update OrderVo set order_flag=2 where order_id=:id");
			query.setParameter("id", id);
			int result = query.executeUpdate();
			   session.close();		
		  return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return 0;
		
	}
	
	public List update(OrderVo cvo1)
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
	
	
//	public List updateflag(UserVo cvo1)
//	{
//		
//		try{
//			Session session=sessionFactory.openSession();
//			Transaction transaction=session.beginTransaction();
//			String update="update user c set c.user_type=4 where c.user_id="+cvo1.getUser_id()+"";
//			session.update(update);
//			transaction.commit();
//			session.close();	
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		return null;
//		}
//	
//	
	public List delete(OrderVo cvo2)
	{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(cvo2);
		tr.commit();
		session.close();
		return null;
		
	}

	
	// tiffinwala code
	
	public List searchorder(int id)
	{
		List orderlist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from OrderVo where tiffinvo_tiffin_id=:id and order_flag=0");
			  q.setParameter("id", id);
			   orderlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return orderlist;
		
	}
	
	public List viewpastorder(int id)
	{
		List orderlist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from OrderVo where tiffinvo_tiffin_id=:id and order_flag=1");
			  q.setParameter("id", id);
			   orderlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return orderlist;
		
	}

	public List returnpandingorders(int id)
	{
		List orderlist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from OrderVo where tiffinvo_tiffin_id=:id and order_flag=0");
			  q.setParameter("id", id);
			   orderlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return orderlist;
		
	}
	
}

