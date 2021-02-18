package com.sh.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="user")
public class User {

	
		// TODO Auto-generated constructor stub
	   
		private int qqnum;
		private String nickName;
		private String password;
		private String registTime;
		private String gender;
		private String introduce;
		private String ip;
		private String email;
	    private int emailstatus;
		
		@Id
		@GeneratedValue(generator="my_gen")
	    @GenericGenerator(name = "my_gen", strategy = "increment")
		public int getQqnum() {
			return qqnum;
		}
		public void setQqnum(int qqnum) {
			this.qqnum = qqnum;
		}
		public String getNickName() {
			return nickName;
		}
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRegistTime() {
			return registTime;
		}
		public void setRegistTime(String string) {
			this.registTime =string;
		}
		
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getIntroduce() {
			return introduce;
		}
		public void setIntroduce(String introduce) {
			this.introduce = introduce;
		}
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getEmailstatus() {
			return emailstatus;
		}
		public void setEmailstatus(int emailstatus) {
			this.emailstatus = emailstatus;
		}
}
