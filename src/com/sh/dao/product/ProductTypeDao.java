package com.sh.dao.product;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sh.entity.Product;
import com.sh.entity.ProductType;
@Repository
public class ProductTypeDao {
	@Resource
	private SessionFactory sessionFactory;
	public List<ProductType> findAll(){
		
		Query query = this.sessionFactory.getCurrentSession().createQuery("from ProductType");
		return query.list();

	}
	
}
	