package com.jsp.student.course;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Aniruddha");
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		Student student1 = new Student();
		student1.setName("Yash");
		student1.setEmail("yashz2@gamil.com");
		
		Student student2 = new Student();
		student2.setName("Shrish");
		student2.setEmail("shrish@gmail.com");
		
		Course course1 = new  Course();
		course1.setName("SQL");
		course1.setDuration("50 days");
		
		Course course2 = new  Course();
		course2.setName("Core Java");
		course2.setDuration("90 days");
		
		Course course3 = new  Course();
		course3.setName("J2EE");
		course3.setDuration("120 days");
		
		ArrayList<Student> s1 = new ArrayList<Student>();
		s1.add(student1);
		s1.add(student2);
		
		ArrayList<Course> c1 = new ArrayList<Course>() ;
		c1.add(course1);
		c1.add(course2);
		c1.add(course3);
		
		student1.setCourses(c1);
		student2.setCourses(c1);
		
		course1.setStudents(s1);
		course2.setStudents(s1);
		course3.setStudents(s1);
		
		
		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityTransaction.commit();
		
		
	}

}
