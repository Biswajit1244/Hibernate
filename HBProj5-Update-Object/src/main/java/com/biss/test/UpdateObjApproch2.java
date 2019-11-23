package com.biss.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.biss.entity.Insurance_policy;
import com.biss.util.HibernateUtil;

public class UpdateObjApproch2 {
/* in this approche we load and get record from the database then we update
 * that column value that are required 
 */
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSession();
		Insurance_policy policy=null;
		Transaction tx=null;
		Boolean flag=false;
		//create obj 
		policy=ses.load(Insurance_policy.class,102);
		try {
			tx=ses.beginTransaction();
			policy.setPrice(5600);
			policy.setTenure(3);
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
