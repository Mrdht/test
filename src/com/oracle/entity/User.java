package com.oracle.entity;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{

	private int id;
	private String name;
	private String password;
	private int age;
	private Date birthDay;
	private String[] hobby;
	private int level;
	private String cartoon;
	
	public User(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	
	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getCartoon() {
		return cartoon;
	}

	public void setCartoon(String cartoon) {
		this.cartoon = cartoon;
	}
	
	
	
	
	
}
