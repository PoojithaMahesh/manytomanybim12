package manytomanybim12.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybim12.dto.Course;
import manytomanybim12.dto.Student;

public class StudentCourseCont {
public static void main(String[] args) {
	Student student1=new Student();
	student1.setId(1);
	student1.setName("Poojitha");
	student1.setAddress("Bangalore");
	
	Student student2=new Student();
	student2.setId(2);
	student2.setName("Fahar");
	student2.setAddress("Bangalore");
	
	Student student3=new Student();
	student3.setId(3);
	student3.setName("Naveen");
	student3.setAddress("Bangalore");
	
	Course course1=new Course();
	course1.setId(1);
	course1.setName("Java");
	course1.setFees(5000);
	
	Course course2=new Course();
	course2.setId(2);
	course2.setName("Advance Java");
	course2.setFees(5000);
	
	Course course3=new Course();
	course3.setId(3);
	course3.setName("SQL");
	course3.setFees(5000);
	
	List<Student> students=new ArrayList<Student>();
	students.add(student1);
	students.add(student2);
	students.add(student3);
	
	List<Course> courses=new ArrayList<Course>();
	courses.add(course1);
	courses.add(course2);
	courses.add(course3);
	
	
	
	
	student1.setCourses(courses);
	student2.setCourses(courses);
	student3.setCourses(courses);
	
	course1.setStudents(students);
	course2.setStudents(students);
	course3.setStudents(students);
	
	
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(student1);
	entityManager.persist(student2);
	entityManager.persist(student3);
	entityManager.persist(course1);
	entityManager.persist(course2);
	entityManager.persist(course3);
	entityTransaction.commit();
	
	
	
	
}
}
