package com.bh.aop;

import com.bh.aop.dao.AccountDAO;
import com.bh.aop.dao.MembershipDAO;
import com.bh.aop.demo.DemoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO =
				context.getBean("membershipDAO", MembershipDAO.class);
				
		// call the business method
		Account myAccount = new Account();
		myAccount.setName("Manfu");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();


		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		
		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		// close the context
		context.close();
	}

}