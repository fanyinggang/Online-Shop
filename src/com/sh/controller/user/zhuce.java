package com.sh.controller.user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.dao.user.UserDaoImpl;
import com.sh.entity.User;
import com.sh.service.UserServiceImpl;
import com.sh.util.IpUtil;
import com.sh.util.SendMail;
@Controller
@RequestMapping("/loginuser")
public class zhuce  {
	@Resource
	private UserServiceImpl userServiceImpl;
	
	
	
	@RequestMapping("/zhuce")
	public String zhuce(@RequestParam("nickName") String nickName,@RequestParam("email") String email,
			@RequestParam("gender") String gender,@RequestParam("introduce") String introduce,@RequestParam("password") String password,
			Model model,HttpSession session){
		User u=new User();
		u.setNickName(nickName);
		u.setEmail(email);
		u.setPassword(password);
		String datetime=(new SimpleDateFormat("yyyy-MM-dd")).format(Calendar.getInstance().getTime());
		u.setRegistTime(datetime);
		u.setGender(gender);
		u.setIntroduce(introduce);
		String ip=IpUtil.getLocalHostAddress();
    	u.setIp(ip);
    	int emailstatus=0;
    	u.setEmailstatus(emailstatus);
        int a=this.userServiceImpl.regist(u);
		model.addAttribute("id",a);
		session.setAttribute("nickName",nickName);
		
		System.out.println("nickName："+nickName);
		System.out.println("email："+email);
		System.out.println("password："+password);
		System.out.println("datetime："+datetime);
		System.out.println("gender："+gender);
		System.out.println("introduce："+introduce);
		System.out.println("ip："+ip);
		System.out.println("emailstatus："+emailstatus);
		SendMail.HostSendMail(email,nickName,a);
		model.addAttribute("tishiinfo","激活邮箱已经发送，请前往邮箱激活");
	 return "login";
	
	}
	
	@RequestMapping("/emailtozhuye")
	public String emailtozhuye(HttpServletRequest request,Model model){
		
		//String nickName=request.getParameter("nickName");
		String username=request.getParameter("id");
		int id=Integer.parseInt(username.toString());
		this.userServiceImpl.jihuoemail(id);
		model.addAttribute("logininfo","邮箱已经激活，请登录");
		return "login";
	}
}