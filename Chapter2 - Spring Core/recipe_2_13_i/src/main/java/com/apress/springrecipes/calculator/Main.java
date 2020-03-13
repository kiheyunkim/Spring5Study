package com.apress.springrecipes.calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception{

        ApplicationContext context =
                new AnnotationConfigApplicationContext(CalculatorConfiguration.class);

        Shape arithmeticCalculator =
                context.getBean("arithmeticCalculator", Shape.class);
        arithmeticCalculator.add(1, 2);
        arithmeticCalculator.sub(4, 3);
        arithmeticCalculator.mul(2, 3);
        arithmeticCalculator.div(4, 2);

        UnitCalculator unitCalculator = context.getBean("unitCalculator", UnitCalculator.class);
        unitCalculator.kilogramToPound(10);
        unitCalculator.kilometerToMile(5);

        
        ((ConfigurableApplicationContext)context).close();
    }
}
