package com.pro.wings.business;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pro.wings.entity.Student;

class Hib_Util {
	public static SessionFactory factory = null;

	public static SessionFactory getFactory()
	{
		if (factory == null)
		{
			return new Configuration().configure("hibernate.cfg2.xml").buildSessionFactory();
		}
		
		return factory;
	}
}

public class StudentHibernate {

	public static void main(String[] args) {

		System.out.println("******************* Hibernate Project Start**********************");

		Student s1 = new Student();
		s1.setStd_name("Anoj");
		s1.setAddress("Kolhapur");
		s1.setMarks(88.5);

		Student s2 = new Student();
		s2.setStd_name("Kiran");
		s2.setAddress("Pune");
		s2.setMarks(86);

		Student s3 = new Student();
		s3.setStd_name("Nilesh");
		s3.setAddress("Mumbai");
		s3.setMarks(85);
		
		try(SessionFactory factory = Hib_Util.getFactory();
			  Session session = factory.openSession())
		{
			Transaction tx = session.beginTransaction();
			
		     session.save(s1);
		     session.save(s2);
		     session.save(s3);
		     
		     tx.commit();
		}
		catch(Exception e)
		{   
			System.out.println("Some error occured during  saving objects ");
			e.printStackTrace();
		}

		System.out.println("******************* Hibernate Project End**********************");
	}

}
