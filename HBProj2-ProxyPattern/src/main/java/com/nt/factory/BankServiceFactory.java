package com.nt.factory;

import com.nt.command.BankServiceImpl;
import com.nt.command.IBankService;
import com.nt.proxy.BankServiceProxy;

public class BankServiceFactory {
	
	public   static   IBankService  getInstance(boolean  isDemonitationEnabled) {
	
		if(isDemonitationEnabled)
			 return  new  BankServiceProxy();
		else
			 return  new  BankServiceImpl();
		
			
	}

}
