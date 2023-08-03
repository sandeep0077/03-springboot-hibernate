package com.springbootHibernate.crudDemo.dao;

import com.springbootHibernate.crudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    // define variable for entity manager
    private final EntityManager entityManager;

    // inject the entity manager using constructor injection
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // save the student
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {

        // create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName",Student.class);

        // return a query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> students = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        students.setParameter("theData",lastName);
        return students.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {

        // retrieve the student to be deleted
           Student student = entityManager.find(Student.class,id);

        // delete a student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {

        // Query to delete all query
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();

    }
}
