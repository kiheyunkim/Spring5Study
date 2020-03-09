package com.Test.Spring;
import org.springframework.beans.factory.config.AbstractFactoryBean;

public class NameUserFactoryBean extends AbstractFactoryBean<User>{
	private User user;
	private String name;
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return user.getClass();
	}

	@Override
	protected User createInstance() throws Exception {
		// TODO Auto-generated method stub
		user.setName(name);
		return user;
	}
}
