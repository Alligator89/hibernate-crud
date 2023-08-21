package com.tms.service;

import com.tms.domain.Student;
import com.tms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Integer id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        student.setId(student.getId());
        student.setAge(student.getAge());
        student.setAverageMark(student.getAverageMark());
        student.setGroup(student.getGroup());
        student.setName(student.getName());
        student.setSurName(student.getSurName());
        studentRepository.save(student);
        return student;
    }

    public void updateStudent(Student student) {
        student.setId(student.getId());
        student.setAge(student.getAge());
        student.setAverageMark(student.getAverageMark());
        student.setGroup(student.getGroup());
        student.setName(student.getName());
        student.setSurName(student.getSurName());
        studentRepository.updateStudent(student);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
}


