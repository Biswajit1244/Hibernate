package com.biss.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory=null;
	static {
		Configuration cfg=null;
		//Activate hibernate framework
		cfg=new Configuration();
		//load and locte hibernate configuration file
		cfg.configure("hibernate.cfg.xml");
		//Create SessionFactory object
		factory=cfg.buildSessionFactory();
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
