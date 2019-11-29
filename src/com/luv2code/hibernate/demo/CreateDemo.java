package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			/** use the session object to save the Java objects */
			
			// create the objects
			Instructor instructor1 = 
					new Instructor("George", "Ramsay", "george@gmail.com");
			
			InstructorDetail instructorDetail1 = 
					new InstructorDetail("george", "guitar");
			
			// associate the objects
			instructor1.setInstructorDetail(instructorDetail1);
			
			// start a transaction
			session.beginTransaction();
			
			
			// save the instructor
			
			// this will also save the details object
			// because of CascadeType.ALL
			session.save(instructor1);
			
			// commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
