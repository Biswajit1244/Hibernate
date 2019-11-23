package com.biss.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.biss.entity.EmployeeEntity;
import com.biss.utility.HibernateUtil;

public class LoadObjTest {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSession();
		EmployeeEntity emp=null;
		try {
		//get the data from table
		emp=ses.get(EmployeeEntity.class, 107);
		if(emp!=null) {
			System.out.println(emp);
		}
		else {
			System.out.println("Record not found");
			}
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
		//close Session obj
		HibernateUtil.closeSession(ses);
		//close factory obj
		HibernateUtil.closeSessionFactory();
		}
	}

}
