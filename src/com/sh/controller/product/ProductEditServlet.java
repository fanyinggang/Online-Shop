package com.sh.controller.product;

import java.io.IOException;
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
import com.sh.entity.ProductType;

@Controller
@RequestMapping("/manager")
public class ProductEditServlet  {
	@Resource
	private ProductDao pd;
	@Resource
	private ProductTypeDao ptd;
	@RequestMapping("/xiugaiProduct")
	public String productpage(@RequestParam("id") String id,Model model) {
		Product p=this.pd.findById(Integer.parseInt(id));
		model.addAttribute("product", p);
		model.addAttribute("action", "edit");
		List<ProductType> list=ptd.findAll();
		model.addAttribute("pts", list);
		return "editproduct";
	}
}
	