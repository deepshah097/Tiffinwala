package com.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.UserVo;
@Repository

public class UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(UserVo uservo)
	{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(uservo);
		tr.commit();
		session.close();
	}
	
	
	public List search()
	{
		List userlist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from UserVo");
			   userlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userlist;
		
	}
	
	
	public int countactiveuser()
	{
		List cntuserlist=new ArrayList();
		int cntusertot=0;
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from UserVo where User_flag=3");
			   cntuserlist=q.list();
			   cntusertot=cntuserlist.size(); 
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return cntusertot;
		
	}
	
	public int countactivetiffinwala()
	{
		List cntuserlist=new ArrayList();
		int cntusertot=0;
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from UserVo where User_flag=2");
			   cntuserlist=q.list();
			   cntusertot=cntuserlist.size(); 
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return cntusertot;
		
	}
	
	public List edit(UserVo cvo)
	{
		List ls=new ArrayList();
		try{
			Session session=sessionFactory.openSession();
			Query q=session.createQuery("from UserVo where id='"+cvo.getUser_id()+"'");
			ls=q.list();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;	
	}
	
	public List update(UserVo cvo1)
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
	
	
	
	
	public int updateflag(int id)
	{
		//int userlist=new ArrayList();
		
		try{
			 Session session=sessionFactory.openSession();
			
			 
			Query query = session.createQuery("update UserVo set user_flag=2 where user_id=:id");
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
	
	public int updatedisapproveflag(int id)
	{
		//int userlist=new ArrayList();
		
		try{
			 Session session=sessionFactory.openSession();
			
			 
			Query query = session.createQuery("update UserVo set user_flag=3 where user_id=:id");
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
	public List delete(UserVo cvo2)
	{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(cvo2);
		tr.commit();
		session.close();
		return null;
		
	}

	public List searchbyuserflag()
	{
		List userlist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from TiffinVo where Tiffin_flag=2");
			   userlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userlist;
		
	}
	
	public List searchbyactivetiffinwala()
	{
		List userlist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from TiffinVo where tiffin_flag=1");
			   userlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userlist;
		
	}
	
	
	public List searchbyactiveusers()
	{
		List userlist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from UserVo where user_flag in (2,3)");
			   userlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userlist;
		
	}
	
	
	public List searchbypendingtiffinwala()
	{
		List userlist=new ArrayList();
		try{
			 Session session=sessionFactory.openSession();
			  Query q=session.createQuery("from TiffinVo where tiffin_flag=0");
			   userlist=q.list();
			   session.close();
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userlist;
		
	}


	public List searchbyuserid(int id) {
		// TODO Auto-generated method stub
		List ls=new ArrayList();
		try{
			Session session=sessionFactory.openSession();
			Query q=session.createQuery("from UserVo where user_id=:id");
			q.setParameter("id", id);
			ls=q.list();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;	
	}
	
	
	public int updatepass(String pass,int id)
	{
		//int userlist=new ArrayList();
		
		try{
			 Session session=sessionFactory.openSession();
			
			 
			Query query = session.createQuery("update UserVo set user_password=:pass where user_id=:id");
			query.setParameter("pass", pass);
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


	

	

//	tiffinwalacode started
	
	
}
