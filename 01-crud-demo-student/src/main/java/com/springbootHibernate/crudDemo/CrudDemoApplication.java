package com.springbootHibernate.crudDemo;

import com.springbootHibernate.crudDemo.dao.StudentDao;
import com.springbootHibernate.crudDemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	@Autowired
	StudentDao studentDao;

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDao studentDao) {
		return runner -> {
			//createStudent(studentDao);
			//readStudent();
			//queryForStudents(studentDao);
			// queryByLastName();
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			deleteAll();
		};
	}

	private void deleteAll() {
		System.out.println("Delete all student : ");
		studentDao.deleteAll();
	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId = 3;
		System.out.println("Deleting accountId : "+ studentId);
		studentDao.deleteStudent(studentId);
	}

	private void queryByLastName() {
		List<Student> students = studentDao.findByLastName("Maurya");
		for(Student temp : students){
			System.out.println("List of Student "+ temp);
		}
	}

	private void queryForStudents(StudentDao studentDao) {

		// get a list of students
		List<Student> students = studentDao.findAll();

		// display list of students
		for(Student temp : students){
			System.out.println("List of Student "+ temp);
		}
	}

	private void createStudent(StudentDao studentDao) {

		// create the student object
		System.out.println("Creating the student..");
		Student student = new Student("Dhoni","Singh", "kavita@gmail.com");


		// save the student object
		studentDao.save(student);

		// display the studentId
		System.out.println("Student save with student id..."+ student.getId());
	}

	private void readStudent(){

		// retrieve student based on primary key
		Student student1 = studentDao.findById(1);
		System.out.println("Read student with studentId : " + student1);
	}

	private  void updateStudent(StudentDao studentDao){

		// retrieve student based on primary key
		Student student = studentDao.findById(1);
		System.out.println("Display student with studentId 1 : "+student);

		// change first name to "scobby"
		student.setFirstName("Neeraj");

		// update student
		studentDao.update(student);

		// display the updated student
		System.out.println("Updated student : "+ student);
	}
}
