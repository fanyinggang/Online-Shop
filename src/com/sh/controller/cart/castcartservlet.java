package com.sh.controller.cart;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.dao.cart.cartDao;
import com.sh.entity.Productsize;
import com.sh.entity.paycart;
import com.sh.entity.showcart;
@Controller
@RequestMapping("/cart")
public class castcartservlet {
	
	@Resource
	private cartDao cd;
	@RequestMapping(value="/cast", method=RequestMethod.POST)
	public String cast(@RequestParam("price") String price,
			@RequestParam("count") String count,@RequestParam("oid") String oid,HttpSession session, Model model){
		int c=Integer.parseInt(count);
		int p=Integer.parseInt(price);
		int num=c*p;
		model.addAttribute("num",num);
		this.cd.updatestutas(Integer.parseInt(oid));
		return "pay";
		
	}
	@RequestMapping(value="/cast", method=RequestMethod.GET)
	public void nocasttodate(@Valid paycart paycart, BindingResult bindingResult,
			HttpSession session, Model model){
		
	}
	@RequestMapping(value="/jiesuansuoyuan", method=RequestMethod.POST)
	public String cast(@RequestParam("ture") String stroid,
			HttpSession session, Model model){
		System.out.println(stroid);
		String listoid[]=stroid.split(",");
		int countprice=0;
		for(int i=0;i<listoid.length;i++){
			String snum	=listoid[i];
			int oid=Integer.parseInt(snum.trim());//trim()去電數字前後的空格
			
			showcart show=this.cd.findshowcartByoid(oid);
			
			this.cd.updatestutas(oid);
			countprice += show.getCount()*show.getPrice();
			
		}
		
		model.addAttribute("num",countprice);
		
		return "pay";
		
	}
}
