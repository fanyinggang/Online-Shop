package com.sh.dao.user;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sh.entity.User;
@Repository
public class UserDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public User findByQqNumAndPassword(int qqnum){
		 User u=this.sessionFactory.getCurrentSession().get(User.class, qqnum);
	        if(u==null){  
	          return null; 
	        }  
	        
	        return  u;
		  
      }
	public int saveUser(User u){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(u); 
       // this.sessionFactory.getCurrentSession().save(u);
		tx.commit(); 
		session.close(); 
		return u.getQqnum();
	}
	
	public void updateemailstatus(int a){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql="update User set emailstatus=? where id=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, 1);
		query.setParameter(1, a);
		query.executeUpdate();
		tx.commit(); 
		session.close(); 
		
	}
	
	public User findByemail(String email){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from User u where u.email=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, email);
        User u = (User) query.uniqueResult();
        tx.commit(); 
        session.close(); 
        if(u==null){  
            return null; 
          }  
          
          return  u;
    } 
	public int findcountByemail(String email){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from User u where u.email=?";
		Query query = session.createQuery(hql);
        query.setParameter(0, email);
        List<User> userList = query.list();
         tx.commit(); 
         session.close();
         return userList.size();
        
	}
}
	
