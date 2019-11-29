package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class EagerLazyDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			/** use the session object to save the Java objects */
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int id = 1;
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			System.out.println("luv2code:) tempInstructor: " + tempInstructor);
			
			// get courses for the instructor
			System.out.println("luv2code:) Courses: " + tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("\nluv2code: The session is closed!\n");
			
			// Option 1: call getter method while session is open
			
			// get courses for the instructor
			System.out.println("luv2code:) Courses: " + tempInstructor.getCourses());
		} finally {
			
			session.close();
			
			factory.close();
		}
	}
}
