package com.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.TiffinVo;
import com.vo.UserVo;
@Repository

public class TiffinDao {


	@Autowired
	SessionFactory sessionFactory;
	
	public void save(TiffinVo tiffinvo)
	{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(tiffinvo);
		tr.commit();
		session.close();
	}
	
	
	public List search()
	{
		List userlist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from TiffinVo");
			   userlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userlist;
		
	}
	
	public List search(int id)
	{
		List userlist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from TiffinVo where uservo_user_id=:id");
			  q.setParameter("id", id);
			   userlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userlist;
		
	}
	
	
	
	
	public List edit(TiffinVo cvo)
	{
		List ls=new ArrayList();
		try{
			Session session=sessionFactory.openSession();
			Query q=session.createQuery("from TiffinVo where id='"+cvo.getTiffin_id()+"'");
			ls=q.list();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;	
	}
	
	public List update(TiffinVo cvo1)
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
	
	
	public int countpendingtiffinwala()
	{
		List cnttiffinlist=new ArrayList();
		int cnttiffintot=0;
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from TiffinVo where tiffin_flag=0");
			   cnttiffinlist=q.list();
			   cnttiffintot=cnttiffinlist.size(); 
			   System.out.println(cnttiffintot);
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return cnttiffintot;
		
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
	
	public int approvetiffinflag(int id)
	{
		//int userlist=new ArrayList();
		
		try{
			 Session session=sessionFactory.openSession();
			
			 
			Query query = session.createQuery("update TiffinVo set tiffin_flag=1 where tiffin_id=:id");
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
	
	public int disapprovetiffinflag(int id)
	{
		//int userlist=new ArrayList();
		
		try{
			 Session session=sessionFactory.openSession();
			
			 
			Query query = session.createQuery("update TiffinVo set tiffin_flag=2 where tiffin_id=:id");
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
	
	
	public List delete(TiffinVo cvo2)
	{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(cvo2);
		tr.commit();
		session.close();
		return null;
		
	}

	
	
//	tiffinwala code started
	
	public List searchbypendingorder()
	{
		List userlist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from OrderVo where order_flag=0");
			   userlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userlist;
		
	}

	public List searchbypendinglistorder(int id)
	{
		List userlist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from TiffinVo where uservo_user_id=:id");
			  q.setParameter("id", id);
			   userlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userlist;
		
	}
	
	public List returntiffinwalaid(int id)
	{
		List userlist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from TiffinVo where uservo_user_id=:id");
			  q.setParameter("id", id);		
			  userlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userlist;
	}
	
}
