package com.biss.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.biss.entity.Insurance_policy;
import com.biss.util.HibernateUtil;

public class UpdateObjApproch4 {
/* This Approach is similar to approach2 Here only Dynamic-update attribute
 * value is true which will generate update query based on the values we are
 * updating not for all value
 */
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSession();
		Insurance_policy policy=null;
		Transaction tx=null;
		Boolean flag=false;
		//create obj 
		policy=ses.load(Insurance_policy.class,101);
		try {
			tx=ses.beginTransaction();
			policy.setPrice(12060);
			policy.setTenure(6);
			ses.update(policy);
			flag=true;
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Record Update Successful");
			}
			else {
				tx.rollback();
				System.out.println("Record Update failed");
			}
		}
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}

}
