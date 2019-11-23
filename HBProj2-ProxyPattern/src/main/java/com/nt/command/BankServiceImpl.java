package com.nt.command;

public class BankServiceImpl implements IBankService {

	@Override
	public String transferMoney(int srcAcno, int destAcno, float amount) {
		return "transfering  amount ::"+amount+" from "+srcAcno+" to"+destAcno;
	}

}
