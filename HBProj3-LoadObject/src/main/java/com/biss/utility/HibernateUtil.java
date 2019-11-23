package com.biss.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory=null;
	static {
		Configuration cfg=null;
		//Create Session factory object
		factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
	}
	public  static  Session getSession() {
		Session ses=null;
		  if(factory!=null)
			    ses=factory.openSession();
		  return ses;
	}
	
	public  static void closeSession(Session ses) {
		 if(ses!=null)
			 ses.close();
	}
	
	public  static  void closeSessionFactory() {
		 if(factory!=null)
			 factory.close();
	}
}
