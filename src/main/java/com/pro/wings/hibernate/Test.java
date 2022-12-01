package com.pro.wings.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
// 	<property name="connectin.username">Dhanashri Rhaykar</property>
//	<property name="connection.password">root@1234</property>
	//rename user 'root'@'localhost' to 'Dhanashri Rhaykar'@'localhost';
	public static void main(String[] args) {

		SessionFactory  factory = new Configuration().configure().buildSessionFactory();
		Person p = new Person(1,"Ram","Pune");
		Person p1 = new Person(2,"sham","Pune");
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		 
		session.save(p);
		session.save(p1);
		
		tx.commit();
		
		
Transaction trsc2 = session.beginTransaction();
		
		List<Person> person = session.createQuery("from Person").list();
		

		trsc2.commit();
		
		
		for(Person city : person)
		{
			System.out.println(city.getId()+" "+city.getName()+" "+city.getAddress());
		}
		
		session.close();
		factory.close();
		
		System.out.println("end Project");
		
	}
}
