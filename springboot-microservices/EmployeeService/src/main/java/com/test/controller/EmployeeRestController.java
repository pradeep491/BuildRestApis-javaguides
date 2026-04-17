package com.test.controller;

import com.test.dtos.EmployeeDTO;
import com.test.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;


    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDTO), HttpStatus.CREATED);
    }
    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDTO> getEmployeeByEmpId(@PathVariable Long empId) {
        return new ResponseEntity<>(employeeService.getEmployeeById(empId), HttpStatus.OK);
    }
}
