package com.sh.service;

import java.util.HashMap;
import java.util.Map;

import com.sh.entity.Product;
import com.sh.entity.showcart;

public class Cart {
	public Map<Integer, CartItem> container = new HashMap<Integer, CartItem>();

	public void addCart(Product pro,String color,String size,int count,showcart objshowcart,int maxobshowid){
			if(objshowcart!=null && container.get(objshowcart.getOid())!=null){
				 CartItem ci=container.get(objshowcart.getOid());
                 System.out.println("objshowcart.getOid(): "+objshowcart.getOid());
				   System.out.println("获得ci的值,ci不为空:"+ci); 
				   int sumcount=objshowcart.getCount()+count;
				   System.out.println("sumcount:"+sumcount); 
                 ci.setCount(sumcount);
				    
					}else{
						
						CartItem ci=new CartItem();
						ci.setProduct(pro);
						ci.setCount(count);
						ci.setColor(color);
						ci.setSize(size);
						if(maxobshowid==1)
						container.put(maxobshowid, ci);
						else{
							container.put(maxobshowid+1, ci);
							System.out.println("objshowcart.getOid(): "+objshowcart.getOid());
							System.out.println("container.get(objshowcart.getOid(): "+container.get(objshowcart.getOid()));
							System.out.println("获得容器的值,容器值为空,赋值给容器值后:"+(maxobshowid+1));
							   System.out.println("获得ci的值,ci为空,赋值给ci后:"+ci);
						
						 
					}
	}
	}}
	

