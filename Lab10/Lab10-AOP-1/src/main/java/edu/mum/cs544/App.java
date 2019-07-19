package edu.mum.cs544;

import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		ICustomerService customerService = context.getBean("customerService", ICustomerService.class);
		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
                "mainstreet 5", "Chicago", "60613");
        context.close();
        System.out.println("Done");
	}
}
