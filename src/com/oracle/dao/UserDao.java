package com.oracle.dao;

import java.util.List;

import com.oracle.entity.User;

public interface UserDao {

	void register(User user);
	
	User login(String name,String password);
	
	User getUserById(int id);
	
	void update(User user);
	
	List<User> getAllUser();
	
	void  updateLevel(int id,int level);
	
	void delete(int id);
	
	Boolean isUserExist(String name);
	
	List<String> getName(String name);
	
	
}
