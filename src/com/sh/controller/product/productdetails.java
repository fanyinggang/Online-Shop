package com.sh.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.dao.product.ProductDao;
import com.sh.dao.product.ProductTypeDao;
import com.sh.entity.Product;
import com.sh.entity.Productcolor;

@Controller
@RequestMapping("/product")

public class productdetails  {
	@Resource
	private ProductDao pd;
	@Resource
	private ProductTypeDao ptd;
	@RequestMapping("/productdetails")
	public String productdetails(@RequestParam("id") String id,Model model) {
		Product p=this.pd.findById(Integer.parseInt(id));
		List list=new ArrayList();
		List pc=pd.findcolorById(Integer.parseInt(id));
		List pz=pd.findsizeById(Integer.parseInt(id));
		model.addAttribute("product",p);
		model.addAttribute("productcolor",pc);
		model.addAttribute("productsize",pz);
		return "single";
		
	
}
}