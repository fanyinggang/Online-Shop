package com.sh.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sh.entity.Product;
import com.sh.entity.Productcolor;
import com.sh.entity.Productsize;
import com.sh.entity.User;
import com.sh.entity.showcart;

@Repository
public class ProductDao {
	@Resource
	private SessionFactory sessionFactory;

	/* 查询全部产品 */

	public List<Product> findAll() {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Product");
		return query.list();

	}

	public Product findById(int id) {
		return this.sessionFactory.getCurrentSession().get(Product.class, id);
	}

	public int addshowcart(showcart showcart) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(showcart);
		tx.commit();
		session.close();
		return showcart.getOid();

	}

	/**
	 * 统计数据个数
	 * 
	 * @return
	 */
	public Long findCountByPage() {
		Query query = this.sessionFactory.getCurrentSession().createQuery("select count(id) from Product");
		return (Long) query.uniqueResult();
	}

	/**
	 * 分页查询数据
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Product> findByPage(int pageNum, int pageSize) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Product");
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();

	}

	public void deleteProduct(Product p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// this.sessionFactory.getCurrentSession().delete(p);
		session.delete(p);
		tx.commit();
		session.close();
	}

	public int addProduct(Product p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
		return p.getId();

	}

	/**
	 * 查询产品之颜色
	 * 
	 * @return
	 */
	public List<String> findcolorById(int productid) {
		String hql = "select name from Productcolor where productid=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, productid);
		List<String> list = (List<String>) query.list();
		return list;
	}

	/**
	 * 查询产品之尺寸
	 * 
	 * @return
	 */
	public List<String> findsizeById(int productid) {
		String hql = "select name from Productsize where productid=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, productid);
		List<String> list = (List<String>) query.list();
		return list;
	}
	
	/**
	 * 按类型统计数据个数
	 * 
	 * @return
	 */
	public Long findCountByPageandtype(int type) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("select count(id) from Product p where p.producttypeid=?");
		query.setParameter(0, type);
		return (Long) query.uniqueResult();
	}

	/**
	 * 按类型分页查询数据
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Product> findByPageandtype(int pageNum, int pageSize,int type) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Product p where p.producttypeid=?");
		query.setParameter(0, type);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();

	}
	public void updateProduct(Product p,int id){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql="update Product pr set pr.name=?, pr.description=?,pr.price=?,pr.discountprice=?,pr.listimg=?,pr.img1=?,pr.producttypeid=? where pr.id=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, p.getName());
		query.setParameter(1, p.getDescription());
		query.setParameter(2, p.getPrice());
		query.setParameter(3, p.getDiscountprice());
		query.setParameter(4, p.getListimg());
		query.setParameter(5, p.getImg1());
		query.setParameter(6, p.getProducttypeid());
		query.setParameter(7, id);
		query.executeUpdate();
		tx.commit(); 
		session.close(); 
}
	public void deletecolor(int id){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql="delete from Productcolor where productid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, id);
		query.executeUpdate();
		tx.commit(); 
		session.close(); 
}
	public void deletesize(int id){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql="delete from Productsize where productid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, id);
		query.executeUpdate();
		tx.commit(); 
		session.close(); 
}
	
}
