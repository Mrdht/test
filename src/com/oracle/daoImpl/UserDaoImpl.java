package com.oracle.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.oracle.dao.UserDao;
import com.oracle.entity.User;
import com.oracle.util.ConnectionTool;

public class UserDaoImpl implements UserDao {

	 Connection conn;
	 PreparedStatement ps;
	 ResultSet rs;
	
	
	public void register(User user) {
		
		conn=ConnectionTool.getConnection();
		
		String sql="insert into user(name,password,age,birthDay,hobby,level,cartoon) values(?,?,?,?,?,?,?)";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getAge());
			ps.setDate(4, user.getBirthDay());
			
			String hs =Arrays.toString(user.getHobby());
			ps.setString(5,hs.substring(1, hs.length()-1));
			ps.setInt(6, user.getLevel());
			ps.setString(7, user.getCartoon());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			ConnectionTool.close(rs, null, ps, conn);
			
		}
		
	}


	public User login(String name, String password) {
		
		conn=ConnectionTool.getConnection();
		
		User user=null;
		
		String sql="select * from user where name=? and password=?";
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
						
		if(rs.next()){
					
			    user=new User();
				user.setAge(rs.getInt("age"));
				user.setBirthDay(rs.getDate("birthDay"));
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setCartoon(rs.getString("cartoon"));
				user.setLevel(rs.getInt("level"));
			   
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			  ConnectionTool.close(rs, null, ps, conn);
		}	
		
		return user;
	}

	
	
	public User getUserById(int id) {
		
       conn=ConnectionTool.getConnection();
       
       User user=null;
		
		String sql="select * from user where id=?";
		
		 
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			rs=ps.executeQuery();
			
			if(rs.next()){
				
			    user=new User();
				user.setAge(rs.getInt("age"));
				user.setBirthDay(rs.getDate("birthDay"));
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setCartoon(rs.getString("cartoon"));
				user.setLevel(rs.getInt("level"));
				String hobby=rs.getString("hobby");
				hobby.substring(1,hobby.length()-1);
				user.setHobby(hobby.split(","));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			ConnectionTool.close(rs, null, ps, conn);
		}	
							
		return user;
	}	
	
	
	
	
	

	public void update(User user) {
		
		conn=ConnectionTool.getConnection();
		
		String sql="update user set name=?,age=?,birthDay=?,hobby=?,cartoon=? where id=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,user.getName());
			ps.setInt(2,user.getAge());
			ps.setDate(3, user.getBirthDay());
			String hs =Arrays.toString(user.getHobby());
			ps.setString(4,hs.substring(1, hs.length()-1));
			ps.setString(5, user.getCartoon());
			ps.setInt(6, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			  ConnectionTool.close(rs, null, ps, conn);
		}	
	}


	@Override
	public List<User> getAllUser() {

     conn=ConnectionTool.getConnection();
     
     List<User> users=new ArrayList<>();
     
     String sql="select * from user";
     
       try {
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
				
		while(rs.next()){
			
			User u=new User();
			
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setAge(rs.getInt("age"));
			u.setBirthDay(rs.getDate("birthDay"));
			u.setCartoon(rs.getString("cartoon"));
			u.setLevel(rs.getInt("level"));
			u.setHobby(rs.getString("hobby").split(","));
			
			users.add(u);
			
		}
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		
		   ConnectionTool.close(rs, null, ps, conn);
	}	
     
   	return users;
   	
	}


	@Override
	public void updateLevel(int id, int level) {

          conn=ConnectionTool.getConnection();
          
           String sql="update user set level=? where id=?";
           
           try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, level);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			ConnectionTool.close(rs, null, ps, conn);
		}	
	     
	}


	@Override
	public void delete(int id) {
		
		conn=ConnectionTool.getConnection();
		
		String sql="delete from user where id=?";
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			ConnectionTool.close(rs, null, ps, conn);
		}	
		
	}


	public Boolean isUserExist(String name) {
		
		conn=ConnectionTool.getConnection();
		
		Boolean flag = null;
		
		String sql="select * from user where name=?";
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,name);
			
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				flag = true;
				
			}else{
				
				flag = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			ConnectionTool.close(rs, null, ps, conn);
		}	
				
		return flag;
	}


	public List<String> getName(String name) {
		
		conn=ConnectionTool.getConnection();
		
		String sql="select name from user where name like ?";
		
		List<String> list=new ArrayList<>();
		
		try {
			
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,name);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
							
			list.add(rs.getString("name"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
}
