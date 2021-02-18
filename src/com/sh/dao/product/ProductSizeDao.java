package com.sh.dao.product;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sh.entity.Productcolor;
import com.sh.entity.Productsize;

@Repository
public class ProductSizeDao {
	@Resource
	private SessionFactory sessionFactory;
	public ProductSizeDao() {
		// TODO Auto-generated constructor stub
	}
	public void addsize(Productsize ps){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(ps);
		tx.commit();
		session.close();
	}
}
