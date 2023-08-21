package com.tms.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "students")
public class Student {
    @SequenceGenerator(name = "studentGen", sequenceName = "students_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "studentGen")
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surName;
    @Column(name = "age")
    private int age;
    @Column(name = "group_number")
    private int group;
    @Column(name = "average_mark")
    private int averageMark;
}
