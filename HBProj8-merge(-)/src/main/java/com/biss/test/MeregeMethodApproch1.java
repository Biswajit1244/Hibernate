package com.biss.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.biss.entity.Insurance_policy;
import com.biss.util.HibernateUtil;

public class MeregeMethodApproch1 {
/*This approach is same as saveOrUpdate(-) but here ses.merge() return
 * a new object. 
 */
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSession();
		Insurance_policy p=null,p1=null;
		Transaction tx=null;
		Boolean flag=false;
		//create obj 
		p=new Insurance_policy();
		p.setPolicyId(108);
		p.setPolicyName("SurakhaBal");
		p.setPolicyType("JCB");p.setPrice(15000);
		p.setTenure(3);
		try {
			tx=ses.beginTransaction();
			p1=(Insurance_policy)ses.merge(p);
			System.out.println(p.hashCode()+" "+p1.hashCode());
			flag=true;
			System.out.println();
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
