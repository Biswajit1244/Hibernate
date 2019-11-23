package com.biss.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.biss.entity.Insurance_policy;
import com.biss.util.HibernateUtil;

public class UpdateObjApproch1 {
/* in this approch hibernate will not check weather the record is 
 * available or not it will update all value which we give Manually..
 */
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSession();
		Insurance_policy policy=null;
		Transaction tx=null;
		Boolean flag=false;
		//create obj 
		policy=new Insurance_policy();
		policy.setPolicyId(100);policy.setPolicyName("Nityanamda");
		policy.setPolicyType("Health");policy.setPrice(20000);
		policy.setTenure(2);
		try {
			tx=ses.beginTransaction();
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
