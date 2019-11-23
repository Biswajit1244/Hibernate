package com.biss.test;

import javax.transaction.Synchronization;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.biss.entity.EmployeeEntity;

public class SaveObjTest {
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tr=null;
		boolean flag=false;
		//activate hibernate framework
		cfg=new Configuration();
		//locate and load configuration file
		cfg.configure("/com/biss/cfgs/hibernate.cfg.xml");
		//create SessionFactory obj
		factory=cfg.buildSessionFactory();
		//get Session obj
		ses=factory.openSession();
		//Create Entity class obj
		EmployeeEntity emp=new EmployeeEntity();
		emp.setEmpId(123);emp.seteName("Dj");
		emp.setJob("DJ Man");emp.setSal(55000.0f);
		//start transaction
		try {
			tr=ses.beginTransaction();
			ses.save(emp);
			flag=true;
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();

		}
		if(flag) {
			tr.commit();
			System.out.println("Record Insertion Succesful");
		}
		else {
			tr.rollback();
			System.out.println("Record Insertion Failed");
		}
		ses.close();
		factory.close();
	}
}
