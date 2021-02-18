package com.sh.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sh.dao.user.UserDaoImpl;
import com.sh.entity.User;
@Service
@Transactional
public class UserServiceImpl {
	@Resource
	private UserDaoImpl userDaoImpl;
	public int regist(User u){
		
		return this.userDaoImpl.saveUser(u);
	}
    public void jihuoemail(int a){
		
		 this.userDaoImpl.updateemailstatus(a);
	}
}

