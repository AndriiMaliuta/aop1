package com.bh.aop;

import com.bh.aop.dao.AccountDAO;
import com.bh.aop.demo.DemoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> theAccounts = theAccountDAO.findAccounts(false);

		System.out.println("\n\nMain program : After ReturningDemoApp");

		System.out.println(theAccounts);

		System.out.println("\n");
		
		context.close();
	}
}