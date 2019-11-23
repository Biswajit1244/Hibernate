package com.biss.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.biss.entity.Insurance_policy;
import com.biss.util.HibernateUtil;

public class SaveOrUpdateApproch1 {
/* in this approach no generator configured in id property value
 * so if the given identity based value is available in DB then it update 
 * otherwise it will insert
 */
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSession();
		Insurance_policy policy=null;
		Transaction tx=null;
		Boolean flag=false;
		//create obj 
		policy=new Insurance_policy();
		policy.setPolicyId(105);policy.setPolicyName("FullProtection");
		policy.setPolicyType("Mobile");policy.setPrice(2500);
		policy.setTenure(2);
		try {
			tx=ses.beginTransaction();
			ses.saveOrUpdate(policy);;
			flag=true;
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Record Save/Update Successful");
			}
			else {
				tx.rollback();
				System.out.println("Record save/update failed");
			}
		}
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}

}
