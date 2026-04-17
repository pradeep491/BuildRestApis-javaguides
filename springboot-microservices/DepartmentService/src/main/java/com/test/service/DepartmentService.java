package com.test.service;

import com.test.dtos.DepartmentDTO;

public interface DepartmentService {

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

    public DepartmentDTO getDepartmentByCode(String deptCode);
}
