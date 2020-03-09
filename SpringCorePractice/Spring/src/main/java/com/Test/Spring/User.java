package com.Test.Spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Lazy
public class User {
	private String name;
	private String passwd;
	private String nickName;

	
	public User() {
		this.name = "name";
		this.passwd = "passwd";
		this.nickName = "nickName";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	@PostConstruct
	public void fuckFront() {
		//System.out.println("printFront");
	}
	
	@PreDestroy
	public void fuckBack() {
		//System.out.println("printback");
	}
}
