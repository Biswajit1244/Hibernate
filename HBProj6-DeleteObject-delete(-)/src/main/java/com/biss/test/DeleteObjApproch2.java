package com.biss.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.biss.entity.Insurance_policy;
import com.biss.util.HibernateUtil;

public class DeleteObjApproch2 {
/*in this approach we load the object from the database if it available 
 * then only delete() generate the delete query otherwise not
 */
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSession();
		Insurance_policy policy=null;
		Transaction tx=null;
		Boolean flag=false;
		//create obj 
		policy=ses.get(Insurance_policy.class,104);
		try {
			tx=ses.beginTransaction();
			ses.delete(policy);
			flag=true;
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Record Delete Successful");
			}
			else {
				tx.rollback();
				System.out.println("Record not found");
			}
		}
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}

}
