package com.springbootHibernate.crudDemo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@NoArgsConstructor
@Table(name ="student")
@ToString
@Getter
@Setter
public class Student {

    // constructor

    @Autowired
    public Student (String firstName , String lastName , String email){
        this.firstName = firstName;
        this.email  = email;
        this.lastName = lastName;
    }


    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;
}
