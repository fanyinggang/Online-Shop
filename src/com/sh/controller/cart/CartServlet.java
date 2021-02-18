package com.sh.controller.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.dao.cart.cartDao;
import com.sh.dao.product.ProductDao;
import com.sh.dao.user.UserDaoImpl;
import com.sh.entity.Product;
import com.sh.entity.showcart;
import com.sh.service.Cart;
import com.sh.service.CartItem;

@Controller
@RequestMapping("/cart")
public class CartServlet {

	@Resource
	private ProductDao productDao;
	@Resource
	private cartDao cd;

	@RequestMapping("/addtocart")
	public String addtocart(@RequestParam("productId") int productid, @RequestParam("color") String color,@RequestParam("size") String size,@RequestParam("count") int count,Model model, HttpSession session) {
		Product p = this.productDao.findById(productid);
		
		Object obj=session.getAttribute("username");
		int userid=Integer.parseInt(obj.toString());
		showcart show=new showcart();
					
					show.setId(userid);
					show.setProductid(p.getId());
					show.setProductname(p.getName());
					show.setCount(count);
					show.setPrice(p.getPrice());
					show.setState(0);
					show.setColor(color);
					show.setSize(size);

		showcart objshowcart=this.cd.findByIdcoulorsize(productid, color, size);
		if(objshowcart==null){
		 int oid=this.productDao.addshowcart(show);
		}else{
		     this.cd.updateshowcart(objshowcart,count);
		     
		}
		return "redirect:/product/productlist";
	}

	@RequestMapping("/delectproincart")
	public String delectproincart(@RequestParam("incartproId") String oid, Model model, HttpSession session) {
		this.cd.delectproincart(Integer.parseInt(oid));
		
	    return "redirect:/cart/showcart";
	
	   }
	}

