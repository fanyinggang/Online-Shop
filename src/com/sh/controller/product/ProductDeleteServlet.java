package com.sh.controller.product;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.dao.product.ProductDao;
import com.sh.entity.Product;

@Controller
@RequestMapping("/manager")
public class ProductDeleteServlet {
	@Resource
	private ProductDao pd;

	@RequestMapping("/productdelete")
	public String productpage(@RequestParam("id") String id,Model model) {
		Product p=this.pd.findById(Integer.parseInt(id));
		this.pd.deleteProduct(p);
	    return "redirect:/manager/productpage";
}
}