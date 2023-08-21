package com.tms.controller;

import com.tms.domain.Student;
import com.tms.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getStudents();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
        Student student = studentService.getStudent(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createStudent(@RequestBody Student student) {
        Student studentInfoSaved = studentService.createStudent(student);
        Student studentInfoResult = studentService.getStudent(studentInfoSaved.getId());
        if (studentInfoResult != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        Student studentUpdated = studentService.getStudent(student.getId());
        if (student.equals(studentUpdated)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        Student studentUpdated = studentService.getStudent(id);
        studentService.deleteStudent(studentUpdated);
        Student student = studentService.getStudent(id);
        if (student == null) {
            return String.valueOf(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } else {
            return String.valueOf(new ResponseEntity<>(HttpStatus.CONFLICT));
        }
    }
}


