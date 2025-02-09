package com.test.controller;

import com.test.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController {

    private static final List<Student> list;

    static {
        list = Arrays.asList(
                new Student(491L, "pradeep", "kandyala"),
                new Student(492L, "punnu", "chowdary"),
                new Student(493L, "jasvin", "chowdary"),
                new Student(494L, "siri", "chowdary"));
    }

    //http://localhost:8080/students
    @GetMapping
    public Student getStudent() {
        return new Student(491L, "pradeep", "kandyala");
    }

    //To return list as a json
    //http://localhost:8080/students/studentsList
    @GetMapping("studentsList")
    public List<Student> getStudentList() {
        return Arrays.asList(
                new Student(491L, "pradeep", "kandyala"),
                new Student(492L, "punnu", "chowdary"),
                new Student(493L, "jasvin", "chowdary"),
                new Student(494L, "siri", "chowdary"));
    }

    //SpringBoot Rest API with the Path Variable
    //http://localhost:8080/students/495
    @GetMapping("{id}")
    public Student getStudentPath(@PathVariable("id") int studentId) {
        return new Student(studentId, "Nani", "chowdary");
    }

    //SpringBoot Rest API with the Path Variable
    //http://localhost:8080/students/496/test1/test2
    @GetMapping("{id}/{first-name}/{last-name}")
    public Student getStudentPath1(@PathVariable("id") int studentId,
                                   @PathVariable("first-name") String fname,
                                   @PathVariable("last-name") String lname) {
        return new Student(studentId, fname, lname);
    }

    //SpringBoot Rest API with Request Param
    //http://localhost:8080/students/requestParam?id=101&first-name=pradeep&last-name=jyotshna
    @GetMapping("requestParam")
    public Student getStudentRequest(@RequestParam("id") int id,
                                     @RequestParam("first-name") String fname,
                                     @RequestParam("last-name") String lname) {
        return new Student(id, fname, lname);
    }

    //SpringBoot Rest API that handles Post Request
    //PostMapping & @RequestBody
    //http://localhost:8080/students/addStudent
    @PostMapping("addStudent")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudentPost(@RequestBody Student student) {
        return student;
    }

    //SpringBoot Rest API that handles Post Request
    //PostMapping & @RequestBody
    //http://localhost:8080/students/getStudent/491
    @GetMapping("/getStudent/{id}")
    public List<Student> addStudentPost(@PathVariable int id) {
        return list.stream().filter(e -> e.getId() == id).toList();
    }

    //SpringBoot Rest API to handle HTTP Put Request - update existing resource
    //http://localhost:8080/students/491/update
    @PutMapping("{id}/update")
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
    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable int id) {
        return "student with " + id + " deleted successfully...!";
    }
    /// ResponseEntity Examples
    //http://localhost:8080/students/responseEntity/student
    @GetMapping("responseEntity/student")
    public ResponseEntity<Student> getStudentResponseEntity() {
        Student student = new Student(491L, "pradeep", "kandyala");
        //return new ResponseEntity<>(student,HttpStatus.OK);
        //return ResponseEntity.ok(student);
        return ResponseEntity.ok()
                .header("custome-header", "pradeep")
                .body(student);
    }
    //To return list as a json
    //http://localhost:8080/students/responseEntity
    @GetMapping("responseEntity")
    public ResponseEntity<List<Student>> getStudentList1() {
        List<Student> list1 = Arrays.asList(
                new Student(491L, "pradeep", "kandyala"),
                new Student(492L, "punnu", "chowdary"),
                new Student(493L, "jasvin", "chowdary"),
                new Student(494L, "siri", "chowdary"));
        return ResponseEntity.ok(list1);
    }
    //SpringBoot Rest API with the Path Variable
    //http://localhost:8080/students/responseEntity/495
    @GetMapping("responseEntity/{id}")
    public ResponseEntity<Student> getStudentPath1(@PathVariable("id") int studentId) {
        Student student = new Student(studentId, "Nani", "chowdary");
        return ResponseEntity.ok(student);
    }

    //SpringBoot Rest API with the Path Variable
    //http://localhost:8080/students/responseEntity/496/test1/test2
    @GetMapping("responseEntity/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> getStudentPath2(@PathVariable("id") int studentId,
                                   @PathVariable("first-name") String fname,
                                   @PathVariable("last-name") String lname) {
        Student student = new Student(studentId, fname, lname);
        return ResponseEntity.ok(student);
    }

    //SpringBoot Rest API with Request Param
    //http://localhost:8080/students/responseEntity/requestParam?id=101&first-name=pradeep&last-name=jyotshna
    @GetMapping("responseEntity/requestParam")
    public ResponseEntity<Student> getStudentRequest1(@RequestParam("id") int id,
                                     @RequestParam("first-name") String fname,
                                     @RequestParam("last-name") String lname) {
        Student student = new Student(id, fname, lname);
        return ResponseEntity.ok(student);
    }
    //SpringBoot Rest API that handles Post Request
    //PostMapping & @RequestBody
    //http://localhost:8080/students/responseEntity/addStudent
    @PostMapping("responseEntity/addStudent")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> addStudentPost1(@RequestBody Student student) {
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
    //SpringBoot Rest API to handle HTTP Put Request - update existing resource
    //http://localhost:8080/students/responseEntity/491/update
    @PutMapping("responseEntity/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> updateStudent1(@RequestBody Student student, @PathVariable int id) {
        Optional<Student> result = list.stream()
                .filter(obj -> obj.getId() == id)
                .peek(obj -> obj.setFirstName(student.getFirstName()))
                .peek(obj -> obj.setLastName(student.getLastName()))
                .findFirst();
        Student student1 = result.orElse(null);
        return ResponseEntity.ok(student1);
    }
    //SpringBoot Rest API to handle HTTP Put Request - delete existing resource
    //http://localhost:8080/students/responseEntity/491/delete
    @DeleteMapping("responseEntity/{id}/delete")
    public ResponseEntity<String> deleteStudent1(@PathVariable int id) {
        String s = "student with " + id + " deleted successfully...!";
        return ResponseEntity.ok(s);
    }
}
