package com.biss.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.biss.entity.EmployeeEntity;
import com.biss.utility.HibernateUtil;

public class LoadObjTest_Load {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSession();
		EmployeeEntity emp=null;
		try {
		//get the data from table
		/*When we get obj from database through load()method it
			do lazy loading means it will not hit the database until we 
			call a non-identifier method*/

		emp=ses.load(EmployeeEntity.class, 107);
		System.out.println(emp);
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
