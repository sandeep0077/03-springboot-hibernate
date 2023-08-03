package com.springbootHibernate.crudDemo.dao;

import com.springbootHibernate.crudDemo.entity.Student;

import java.util.List;

public interface StudentDao {

     void save(Student theStudent);

     public Student findById(Integer id);

     List<Student> findAll();

     List<Student> findByLastName(String lastName);

     void update(Student student);

     void deleteStudent(Integer id);

     int deleteAll();

}
