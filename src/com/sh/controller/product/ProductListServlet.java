package com.sh.controller.product;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.util.List;

import com.sh.dao.product.ProductDao;
import com.sh.dao.user.UserDaoImpl;
import com.sh.entity.Page;
import com.sh.entity.Product;

@Controller
@RequestMapping("/product")
public class ProductListServlet {
	@Resource
	private ProductDao productDao;

	@RequestMapping("/productlist")
	public String productlist(Model model,HttpServletRequest request) {
		String pageNum = request.getParameter("pageNum");
		System.out.println("pageNum"+pageNum);
		int num = 0;
		if (pageNum == null || pageNum.equals("")) {
			num = 1;
		} else {
			num = Integer.parseInt(pageNum);
		}
		int count=Integer.parseInt(this.productDao.findCountByPage().toString());
		System.out.println("count"+count);
		List<Product> list=this.productDao.findByPage(num, 8);//一页查询的个数
		Page<Product> p=new Page<Product>(num, 8);//一页查询的个数，应大于等于一页查询的个数
		p.setList(list);
		p.setTotalCount(count);
		model.addAttribute("page", p);
		
		return "shopfenye";
	}
	
	
	@RequestMapping("/topshan")
	public String producttopshan(Model model,HttpServletRequest request) {
		String pageNum = request.getParameter("pageNum");
		System.out.println("pageNum"+pageNum);
		int num = 0;
		if (pageNum == null || pageNum.equals("")) {
			num = 1;
		} else {
			num = Integer.parseInt(pageNum);
		}
		int count=Integer.parseInt(this.productDao.findCountByPageandtype(1).toString());
		System.out.println("count"+count);
		List<Product> list=this.productDao.findByPageandtype(num, 4,1);//一页查询的个数
		Page<Product> p=new Page<Product>(num, 4);//一页查询的个数，应大于等于一页查询的个数
		p.setList(list);
		p.setTotalCount(count);
		model.addAttribute("page", p);
		
		return "shoptypetop";
	}
	
	
	@RequestMapping("/sudown")
	public String productsudown(Model model,HttpServletRequest request) {
		String pageNum = request.getParameter("pageNum");
		System.out.println("pageNum"+pageNum);
		int num = 0;
		if (pageNum == null || pageNum.equals("")) {
			num = 1;
		} else {
			num = Integer.parseInt(pageNum);
		}
		int count=Integer.parseInt(this.productDao.findCountByPageandtype(2).toString());
		System.out.println("count"+count);
		List<Product> list=this.productDao.findByPageandtype(num, 4,2);//一页查询的个数
		Page<Product> p=new Page<Product>(num, 4);//一页查询的个数，应大于等于一页查询的个数
		p.setList(list);
		p.setTotalCount(count);
		model.addAttribute("page", p);
		
		return "shoptypedown";
	
	}
	
}
