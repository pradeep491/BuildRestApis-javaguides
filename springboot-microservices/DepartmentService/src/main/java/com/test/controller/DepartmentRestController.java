package com.test.controller;

import com.test.dtos.DepartmentDTO;
import com.test.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentRestController {

    private final DepartmentService departmentService;


    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return new ResponseEntity<>(departmentService.createDepartment(departmentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{deptCode}")
    public ResponseEntity<DepartmentDTO> getDepartmentByDeptCode(@PathVariable String deptCode) {
        return new ResponseEntity<>(departmentService.getDepartmentByCode(deptCode), HttpStatus.OK);
    }
}
