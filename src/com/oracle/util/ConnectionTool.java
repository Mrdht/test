package com.oracle.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTool {

	private static String url="jdbc:mysql://localhost:3306/for1611";
	private static String user="root";
	private static String password="root";
	
	static{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		
		Connection conn=null;
		
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	
	public static void close(ResultSet rs,Statement st,PreparedStatement ps,Connection conn){
		
		try {
				if(rs !=null){
					
					rs.close();
				}
				
				if(st !=null){
					
					st.close();
				}
				
				if(conn !=null){
					
					conn.close();
				}
				
				if(ps!=null){
					
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
	}
	
	    
}
