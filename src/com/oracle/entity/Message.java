package com.oracle.entity;

import java.sql.Date;
import java.sql.Timestamp;



public class Message {

	private int id;
	private String content;
	private String fromName;
	private String toName;
	private Timestamp messTime;
	private String fromImg;
	private String toImg;
	
	public Message(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public Timestamp getMessTime() {
		return messTime;
	}

	public void setMessTime(Timestamp timestamp) {
		this.messTime = timestamp;
	}

	public String getFromImg() {
		return fromImg;
	}

	public void setFromImg(String fromImg) {
		this.fromImg = fromImg;
	}

	public String getToImg() {
		return toImg;
	}

	public void setToImg(String toImg) {
		this.toImg = toImg;
	}
	
	
	
	
}
