package com.sh.controller.product;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sh.dao.product.ProductDao;
import com.sh.entity.Page;
import com.sh.entity.Product;

@Controller
@RequestMapping("/manager")
public class ProductPageServlet {

	@Resource
	private ProductDao pd;

	@RequestMapping("/productpage")
	public String productpage(HttpServletRequest request, Model model) {
		String pageNum = request.getParameter("pageNum");
		System.out.println("pageNum"+pageNum);
		int num = 0;
		if (pageNum == null || pageNum.equals("")) {
			num = 1;
		} else {
			num = Integer.parseInt(pageNum);
		}
		int count=Integer.parseInt(this.pd.findCountByPage().toString());
		System.out.println("count"+count);
		List<Product> list=this.pd.findByPage(num, 2);
		Page<Product> p=new Page<Product>(num, 2);
		p.setList(list);
		p.setTotalCount(count);
		model.addAttribute("page", p);
		return "fenyezhanshi";
	}

}
