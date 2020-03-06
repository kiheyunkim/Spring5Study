package com.apress.springrecipes.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.apress.springrecipes.sequence.config.SequenceGeneratorConfiguration;

//decide Scanning Range
/*
@ComponentScan(
	includeFilters = {
			@ComponentScan.Filter(
				type = FilterType.REGEX,
				pattern = {"com.apress.springrecipes.sequence.*Dao",
						   "com.apress.springrecipes.sequence.*Service"})
	},
	excludeFilters = {
			@ComponentScan.Filter(
				type = FilterType.ANNOTATION,
				classes = {org.springframework.stereotype.Controller.class})
	}
)
*/
public class Main {

    public static void main(String[] args) {
        //ApplicationContext context =	//Annotation Scanning Start -> Instance IoC Container
        //        new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);

    	ApplicationContext context = new AnnotationConfigApplicationContext("com.apress.springrecipes.sequence");
    	
        //SequenceGenerator generator = (SequenceGenerator)context.getBean("SequenceGenerator");//Get Bean by Name & Return java.lang.Object
        //SequenceGenerator generator = context.getBean("SequenceGenerator", SequenceGenerator.class);	//Get Bean by Name and class Name & Return class Type
        //SequenceGenerator generator = context.getBean(SequenceGenerator.class);	//if Bean is unique, Get Bean by class Name

        //System.out.println(generator.getSequence());
        //System.out.println(generator.getSequence());
        
        SequenceDao sequenceDao = context.getBean(SequenceDao.class);
        
        System.out.println(sequenceDao.getNextValue("IT"));
        System.out.println(sequenceDao.getNextValue("IT"));
        
        ((ConfigurableApplicationContext)context).close();
    }
}