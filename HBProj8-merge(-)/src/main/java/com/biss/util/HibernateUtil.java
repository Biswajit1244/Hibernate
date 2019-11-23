package com.biss.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		Configuration cfg=null;
		//get SessionFactory obj
		factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
	}
	//Get Session class object
	public static Session getSession() {
		Session ses=null;
		if(factory!=null) {
			ses=factory.openSession();
		}
	return ses;
	}
	//close Session
	public  static void closeSession(Session ses) {
		 if(ses!=null)
			 ses.close();
	}
	//close factory
	public  static  void closeSessionFactory() {
		 if(factory!=null)
			 factory.close();
	}
}
