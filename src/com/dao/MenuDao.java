package com.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.MenuVo;
@Repository

public class MenuDao {


	@Autowired
	SessionFactory sessionFactory;
	
	public void save(MenuVo menuvo)
	{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(menuvo);
		tr.commit();
		session.close();
	}
	
	
	public List search()
	{
		List menulist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from MenuVo");
			   menulist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return menulist;
		
	}
	
	
	public List search(int id)
	{
		List menulist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from MenuVo where tiffinvo_tiffin_id=:id");
			  q.setParameter("id", id);
			   menulist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return menulist;
		
	}
	
	public List searchbypastmenu(int id)
	{
		List menulist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from MenuVo where tiffinvo_tiffin_id=:id AND current=0");
			  q.setParameter("id", id);
			   menulist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return menulist;
		
	}
	
	public List searchbycurrentmenu(int id)
	{
		List menulist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from MenuVo where tiffinvo_tiffin_id=:id AND current=1");
			  q.setParameter("id", id);
			   menulist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return menulist;
		
	}
	
	
	
	public List edit(MenuVo cvo)
	{
		List ls=new ArrayList();
		try{
			Session session=sessionFactory.openSession();
			Query q=session.createQuery("from MenuVo where id='"+cvo.getMenu_id()+"'");
			ls=q.list();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;	
	}
	
	public int approvemenuflag(int id)
	{
		List userlist=new ArrayList();
		
		try{
			 Session session=sessionFactory.openSession();
			
			 
			Query query = session.createQuery("update MenuVo set current=0 where menu_id=:id");
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
	
	
	public List update(MenuVo cvo1)
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
	
	public List delete(MenuVo cvo2)
	{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(cvo2);
		tr.commit();
		session.close();
		return null;
		
	}

	
}
