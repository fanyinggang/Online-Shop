package com.sh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="productsize")
public class Productsize {
	private int id;
	private String name;
	private int productid;
	
	
	
	@Id
	@GeneratedValue(generator="my_geng")
    @GenericGenerator(name = "my_geng", strategy = "increment")
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getProductid() {
		return productid;
	}




	public void setProductid(int productid) {
		this.productid = productid;
	}




	public Productsize() {
		// TODO Auto-generated constructor stub
	}
	

}
