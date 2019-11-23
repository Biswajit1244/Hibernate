package com.nt.test;

import com.nt.command.IBankService;
import com.nt.factory.BankServiceFactory;

public class ProxyPatternTest {

	public static void main(String[] args) {
		IBankService  service=null;
	    //get BankService class object
		service=BankServiceFactory.getInstance(true);
		System.out.println("service obj class"+service.getClass());
		try {
		System.out.println(service.transferMoney(1001, 1002, 90000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
		System.out.println(service.transferMoney(1001, 1002, 900000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("...................................");
		service=BankServiceFactory.getInstance(false);
		System.out.println("service obj class"+service.getClass());
		try {
		System.out.println(service.transferMoney(1001, 1002, 6000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
		System.out.println(service.transferMoney(1001, 1002, 600000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		


	}//main
}//class
