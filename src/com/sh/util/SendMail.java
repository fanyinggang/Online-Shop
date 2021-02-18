package com.sh.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.iap.Response;

public class SendMail {

	public SendMail() {
		// TODO Auto-generated constructor stub
	}
	public static void HostSendMail(String email,String nickName,int a) {
	Properties props = System.getProperties();
	props.put("mail.smtp.host", "smtp.163.com");
	props.put("mail.smtp.auth", "true");
	Session session = Session.getInstance(props, new Authenticator() {
		public PasswordAuthentication getPasswordAuthentication() { 
			return new PasswordAuthentication("fanyinggang1", "15703286379fan");/*此处的‘密码’应当是163邮箱的授权码*/
		}
	});
	Message msg = new MimeMessage(session);
	try {
		msg.setFrom(new InternetAddress("fanyinggang1@163.com"));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		msg.setSubject("注册邮箱激活信息");
		msg.setText("您已注册网上商店，点击链接请激活：http://localhost:8080/myshop/loginuser/emailtozhuye?nickName="+nickName+"&id="+a);
		msg.setHeader("X-Mailer", "smtpsend");
		msg.setSentDate(new Date());
		for(int i=0;i<1;i++){
		Transport.send(msg);
		
		}
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

}
