package com.test.controller;

import com.test.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private static final List<Student> list;

    static {
        list = Arrays.asList(
                new Student(491L, "pradeep", "kandyala"),
                new Student(492L, "punnu", "chowdary"),
                new Student(493L, "jasvin", "chowdary"),
                new Student(494L, "siri", "chowdary"));
    }

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

    //SpringBoot Rest API with Request Param
    //http://localhost:8080/students/requestParam?id=101&first-name=pradeep&last-name=jyotshna
    @GetMapping("/students/requestParam")
    public Student getStudentRequest(@RequestParam("id") int id,
                                     @RequestParam("first-name") String fname,
                                     @RequestParam("last-name") String lname) {
        return new Student(id, fname, lname);
    }

    //SpringBoot Rest API that handles Post Request
    //PostMapping & @RequestBody
    //http://localhost:8080/addStudent
    @PostMapping("/addStudent")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudentPost(@RequestBody Student student) {
        return student;
    }

    //SpringBoot Rest API that handles Post Request
    //PostMapping & @RequestBody
    //http://localhost:8080/getStudent/491
    @GetMapping("/getStudent/{id}")
    public List<Student> addStudentPost(@PathVariable int id) {
        return list.stream().filter(e -> e.getId() == id).toList();
    }

    //SpringBoot Rest API to handle HTTP Put Request - update existing resource
    //http://localhost:8080/students/491/update
    @PutMapping("/students/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
        Optional<Student> result = list.stream()
                .filter(obj -> obj.getId() == id)
                .peek(obj -> obj.setFirstName(student.getFirstName()))
                .peek(obj -> obj.setLastName(student.getLastName()))
                .findFirst();
        return result.orElse(null);
    }

    //SpringBoot Rest API to handle HTTP Put Request - delete existing resource
    //http://localhost:8080/students/491/delete
    @DeleteMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable int id) {
        return "student with " + id + " deleted successfully...!";
    }
}
