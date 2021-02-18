package com.sh.dao.cart;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sh.entity.Product;
import com.sh.entity.User;
import com.sh.entity.showcart;

@Repository
public class cartDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public void delectproincart(int oid) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from showcart where oid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, oid);
		query.executeUpdate();
		tx.commit();
		session.close();
	}
	public showcart findByIdcoulorsize(int productid,String color,String size) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from showcart s where s.productid=? and s.color=? and s.size=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, productid);
		query.setParameter(1, color);
		query.setParameter(2, size);
		 //List<showcart> showcartList = query.list();
		showcart showcart = (showcart) query.uniqueResult();
		tx.commit();
		session.close();
		return showcart;
	}
	public void updateshowcart(showcart objshowcart, int count) {
		System.out.println("進入了更新函數");
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql="update showcart sh set sh.count=? where sh.oid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, objshowcart.getCount()+count);
		query.setParameter(1, objshowcart.getOid());
		query.executeUpdate();
		tx.commit();
		session.close();
		
	}
	public int findmaxobjshowcartoid() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql="select max(sc.oid) from showcart sc ";
		Query query = session.createQuery(hql);
		Object objmaxobjshowoid= query.uniqueResult();
		System.out.println("objmaxobjshowoid: "+objmaxobjshowoid);
		tx.commit();
		session.close();
		if(objmaxobjshowoid==null){
			int maxobjshowoid=0;
			return maxobjshowoid;
		}else{
			int maxobjshowoid=Integer.parseInt(objmaxobjshowoid.toString());
			System.out.println("maxobjshowoid不为空时: "+maxobjshowoid);
			return maxobjshowoid;
		}
		
	}
	public List<showcart> showdingdan() {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from showcart sh where sh.state=?");
		query.setParameter(0, 0);
		return query.list();

	}
	
	public List<showcart> showyijiesuandingdan() {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from showcart sh where sh.state=?");
		query.setParameter(0, 1);
		return query.list();

	}
	
	public void updatestutas(int a){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql="update showcart set state=? where oid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, 1);
		query.setParameter(1, a);
		query.executeUpdate();
		tx.commit(); 
		session.close(); 
		
	}
	public showcart findshowcartByoid(int oid){
		showcart showcart=this.sessionFactory.getCurrentSession().get(showcart.class, oid);
	        if(showcart==null){  
	          return null; 
	        }  
	        
	        return  showcart;
		  
     }
}
