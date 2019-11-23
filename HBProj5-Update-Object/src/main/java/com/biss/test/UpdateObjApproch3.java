package com.biss.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.biss.entity.Insurance_policy;
import com.biss.util.HibernateUtil;

public class UpdateObjApproch3 {
/*in approach we are updating obj without ses.update()
 * Actually this can be possible because of Syncronization between 
 * obj value and dB table column value
 */
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSession();
		Insurance_policy policy=null;
		Transaction tx=null;
		Boolean flag=false;
		//create obj 
		policy=ses.load(Insurance_policy.class,100);
		try {
			tx=ses.beginTransaction();
			policy.setPolicyName("Sukha Santi");
			policy.setPrice(203600);
			policy.setTenure(4);
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
