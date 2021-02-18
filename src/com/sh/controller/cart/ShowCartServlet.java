package com.sh.controller.cart;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.sh.dao.product.ProductColorDao;
import com.sh.dao.product.ProductDao;
import com.sh.entity.Product;
import com.sh.entity.showcart;
import com.sh.service.Cart;
import com.sh.service.CartItem;
@Controller
@RequestMapping("/cart")

public class ShowCartServlet  {
	@Resource
	private ProductDao productDao;
	
	@Resource
	private cartDao cd;

	@RequestMapping("/showcart")
	public String showcart( Model model, HttpSession session) {
		List<showcart> list = this.cd.showdingdan();
		model.addAttribute("showcartobject", list);
		return "cast";
	}
	@RequestMapping("/showyijiesuancart")
	public String yijiesuanshowcart( Model model, HttpSession session) {
		List<showcart> list = this.cd.showyijiesuandingdan();
		model.addAttribute("showcartobject", list);
		return "castyijiesuan";
	}
	@RequestMapping("/delectjiesuansuoyuan")
	public String cast(@RequestParam("ture") String stroid,
					HttpSession session, Model model){
				System.out.println(stroid);
				String listoid[]=stroid.split(",");
				int countprice=0;
				for(int i=0;i<listoid.length;i++){
					String snum	=listoid[i];
					int oid=Integer.parseInt(snum.trim());//trim()去電數字前後的空格
					
					this.cd.delectproincart(oid);
					
				}
				
			
				
				return "redirect:/cart/showyijiesuancart";
				
			}
}