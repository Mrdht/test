package com.oracle.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.dao.MessageDao;
import com.oracle.entity.Message;
import com.oracle.util.ConnectionTool;

public class MessageDaoImpl implements MessageDao{

	 Connection conn;
	 PreparedStatement ps;
	 ResultSet rs;
	 
	public void addMessage(Message ms) {
		
		conn=ConnectionTool.getConnection();
		String sql="insert into message(content,fromName,toName,messTime,fromImg,toImg) values(?,?,?,now(),?,(select cartoon from user where name=?))";
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, ms.getContent());
			ps.setString(2, ms.getFromName());
			ps.setString(3, ms.getToName());
			ps.setString(4, ms.getFromImg());
			ps.setString(5, ms.getToName());
			
			ps.executeUpdate();
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			ConnectionTool.close(rs, null, ps, conn);
			
		}
		
	}

	
	public List<Message> getAllMessage() {
		
		List<Message> list=new ArrayList<>();
		
		conn=ConnectionTool.getConnection();
		
		String sql="select * from message ";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Message message=new Message();
				message.setContent(rs.getString("content"));
				message.setFromImg(rs.getString("fromImg"));
				message.setFromName(rs.getString("fromName"));
				message.setId(rs.getInt("id"));
				message.setMessTime(rs.getTimestamp("messTime"));
				message.setToImg(rs.getString("toImg"));
				message.setToName(rs.getString("toName"));
				list.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			ConnectionTool.close(rs, null, ps, conn);
			
		}
		return list;
	}


	public List<Message> getMyMessage(String fromMyName, String toMyName) {
		
		conn=ConnectionTool.getConnection();
		
		List<Message> list=new ArrayList<>();
		
		String sql="select * from message where fromName=? or toName=?";
		
		try {
			
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, fromMyName);
			ps.setString(2, toMyName);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				Message message=new Message();
				
				message.setContent(rs.getString("content"));
				message.setFromImg(rs.getString("fromImg"));
				message.setFromName(rs.getString("fromName"));
				message.setId(rs.getInt("id"));
				message.setMessTime(rs.getTimestamp("messTime"));
				message.setToImg(rs.getString("toImg"));
				message.setToName(rs.getString("toName"));
				
				list.add(message);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		return list;
		
	}
	
}
