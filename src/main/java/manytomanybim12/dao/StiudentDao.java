package manytomanybim12.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybim12.dto.Course;
import manytomanybim12.dto.Student;

public class StiudentDao {
public EntityManager getEntityManager() {
	return Persistence.createEntityManagerFactory("vinod").createEntityManager();
}

public void updateStudent(int id,Student student) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Student dbStudent=entityManager.find(Student.class, id);
	if(dbStudent!=null) {
//		id is present
		entityTransaction.begin();
		student.setId(id);
		student.setCourses(dbStudent.getCourses());
		entityManager.merge(student);
		entityTransaction.commit();
	}else {
		System.out.println("Sorry Id is not present");
	}
}

public void deleteStudent(int id) {

EntityManager entityManager=getEntityManager();
EntityTransaction entityTransaction=entityManager.getTransaction();
Student dbStudent=entityManager.find(Student.class, id);
if(dbStudent!=null) {
//	id is present
	entityTransaction.begin();
	List<Course> courses=dbStudent.getCourses();
	for(Course course:courses) {
		List<Student> students=course.getStudents();
		students.remove(dbStudent);
//		students==all new stiudent list
		course.setStudents(students);
	}
	entityManager.remove(dbStudent);
	entityTransaction.commit();
}else {
	System.out.println("Sorry Id is not present");
}
}

public void findStudent(int id) {

EntityManager entityManager=getEntityManager();
EntityTransaction entityTransaction=entityManager.getTransaction();
Student dbStudent=entityManager.find(Student.class, id);
if(dbStudent!=null) {
//	id is present
	System.out.println(dbStudent);
}else {
	System.out.println("Sorry Id is not present");
}
}










}
