package com.oracle.test;

import com.oracle.daoImpl.UserDaoImpl;
import com.oracle.entity.User;

public class Test {

public static void main(String[] args) {
		
		UserDaoImpl udi=new UserDaoImpl();
		
		//User user=udi.login("境今摸","境今摸");
		
		//System.out.println(user.getName());
		
		  User user=udi.getUserById(1);
		  
		  System.out.println(user.getHobby());
		
   }

}
