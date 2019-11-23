package com.biss.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.biss.entity.Insurance_policy;
import com.biss.util.HibernateUtil;

public class DeleteObjApproch1 {
/* In approach we directly deleteing the record without checking the
 * record is available or not..If it is available it will delete the record 
 * otherwise throws hibernate Exception
 */
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSession();
		Insurance_policy policy=null;
		Transaction tx=null;
		Boolean flag=false;
		//create obj 
		policy=new Insurance_policy();
		policy.setPolicyId(105);
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
