package com.oracle.dao;

import java.util.List;

import com.oracle.entity.Message;

public interface MessageDao {

	void addMessage(Message ms);
	
	List<Message> getAllMessage();
	
	List<Message> getMyMessage(String fromMyName,String toMyName);
}
