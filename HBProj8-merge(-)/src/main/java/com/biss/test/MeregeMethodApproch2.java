package com.biss.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.biss.entity.Insurance_policy;
import com.biss.util.HibernateUtil;

public class MeregeMethodApproch2 { 
/*in this approach if the entity class obj is already loaded in L1Catche
 * then if we do update,save,other persitence operation with that identifier based 
 * obj class then it will through error NonUnique...
 * if we use merge(-) then it will do update or insert operation and return that same obj
 * that is loaded in the L1Catche with updated value..
 *   
 */
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSession();
		Insurance_policy p=null,p1=null,p2=null;
		Transaction tx=null;
		Boolean flag=false;
		//create obj 
		p=ses.get(Insurance_policy.class,104);
		try {
			tx=ses.beginTransaction();
			p2=new Insurance_policy();
			p2.setPolicyId(104);p2.setPolicyName("GoodProtect");
			p2.setPolicyType(" vehicel");
			p1=(Insurance_policy) ses.merge(p2);
			System.out.println(p.hashCode()+" "+p2.hashCode()+" "+p1.hashCode());
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
