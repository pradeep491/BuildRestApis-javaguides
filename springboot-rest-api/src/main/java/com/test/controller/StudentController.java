package com.test.controller;

import com.test.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent() {
        return new Student(491L, "pradeep", "kandyala");
    }

    //To return list as a json
    //http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudentList() {
        return Arrays.asList(
                new Student(491L, "pradeep", "kandyala"),
                new Student(492L, "punnu", "chowdary"),
                new Student(493L, "jasvin", "chowdary"),
                new Student(494L, "siri", "chowdary"));
    }

    //SpringBoot Rest API with the Path Variable
    //http://localhost:8080/students/495
    @GetMapping("/students/{id}")
    public Student getStudentPath(@PathVariable("id") int studentId) {
        return new Student(studentId, "Nani", "chowdary");
    }

    //SpringBoot Rest API with the Path Variable
    //http://localhost:8080/students/496/test1/test2
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public Student getStudentPath1(@PathVariable("id") int studentId,
                                  @PathVariable("first-name") String fname,
                                  @PathVariable("last-name") String lname) {
        return new Student(studentId, fname, lname);
    }
}
