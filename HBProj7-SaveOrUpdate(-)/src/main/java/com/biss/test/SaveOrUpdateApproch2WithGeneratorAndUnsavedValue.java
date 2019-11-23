package com.biss.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.biss.entity.Insurance_policy;
import com.biss.util.HibernateUtil;

public class SaveOrUpdateApproch2WithGeneratorAndUnsavedValue {
/* in this approach we set unsaved-value attribute true of class tag in mapping file
 * and generator is enabled
 * If the unsaved-value attribute value and id property value is matched then record will be inserted
 * otherwise the unsaved-value and id property value is not matched then record will updated
 * 
 * 
 * 
 */
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSession();
		Insurance_policy policy=null;
		Transaction tx=null;
		Boolean flag=false;
		//create obj 
		policy=new Insurance_policy();
		policy.setPolicyId(108);
		policy.setPolicyName("SurakhaBal");
		policy.setPolicyType("JCB");policy.setPrice(15000);
		policy.setTenure(3);
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
