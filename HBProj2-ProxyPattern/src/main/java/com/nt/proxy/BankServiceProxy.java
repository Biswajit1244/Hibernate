package com.nt.proxy;

import com.nt.command.BankServiceImpl;
import com.nt.command.IBankService;

public class BankServiceProxy implements IBankService {
	IBankService real=null;
	  public BankServiceProxy() {
		real=new BankServiceImpl();
	}

	@Override
	public String transferMoney(int srcAcno, int destAcno, float amount) {
		String result=null;
		 if(amount>200000)
			   throw new IllegalArgumentException("u can not more than 2 lacs , during the period of demonitization");
		 else {
			 //use real object
			 result=real.transferMoney(srcAcno, destAcno, amount);
		 }
		return result;
	}

}
