package com.apress.springrecipes.sequence;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

//When Bean Created, All Beans Call these two methods
@Component
public class AuditCheckBeanPostProcessor implements BeanPostProcessor {
	//d
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
    	
		System.out.println("postProcessBeforeInitialization: " + beanName);
    	
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
    	
		System.out.println("postProcessAfterInitialization: " + beanName);
    	
        return bean;
    }
}
