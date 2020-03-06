package com.apress.springrecipes.shop;

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
    	
    	if(bean instanceof Product) {
    		String productName = ((Product)bean).getName();
    		System.out.println("In ProductCheckBeanPostProcessor. postProcessBeforeInitialization, processing Product :" + productName);
    	}
    	
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
    	
    	if(bean instanceof Product) {
    		String productName = ((Product)bean).getName();
    		System.out.println("In ProductCheckBeanPostProcessor. postProcessAfterInitialization, processing Product :" + productName);
    	}
    	
        return bean;
    }
}
