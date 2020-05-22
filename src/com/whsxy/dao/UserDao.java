package com.whsxy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.whsxy.entity.User;

@Repository("userDao")
public interface UserDao {

	User findUserById(int id);

	List<User> findAllUser();

	void dodeleteUser(int isd);

	void doregist(User user);

	void doupdate(User user);

}
