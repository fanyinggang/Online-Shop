package com.sh.dao.product;
import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sh.entity.Productcolor;
@Repository
public class ProductColorDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public void addColor(Productcolor pc){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(pc);
		tx.commit();
		session.close();
	}
}
