package com.whsxy.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whsxy.dao.UserDao;
import com.whsxy.entity.User;

@Service("userService")
public class UserService {
	
	@Resource(name="userDao")
	UserDao dao;



	public User findUserById(int id) {
		// TODO Auto-generated method stub
		User user=dao.findUserById(id);
		return user;
	}



	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		List<User> users=new ArrayList<User>();
		users=dao.findAllUser();
		return users;
	}



	public void dodeleteUser(int isd) {
		dao.dodeleteUser(isd);
		
	}



	public void doregist(User user) {
		// TODO Auto-generated method stub
		dao.doregist(user);
		
	}



	public void doupdate(User user) {
		// TODO Auto-generated method stub
		dao.doupdate(user);
		
	}
}
