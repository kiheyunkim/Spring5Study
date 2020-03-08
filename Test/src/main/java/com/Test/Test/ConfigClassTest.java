package com.Test.Test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("configClass")
@Scope(value = "prototype")
public class ConfigClassTest implements ConfigClass{
	private Integer index =  new Integer(0);
	
	public int GetIndex() {
		index = index + 1;
		return index;
	}

}
