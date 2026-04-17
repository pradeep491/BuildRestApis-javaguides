package com.test.service;

import com.test.dtos.EmployeeDTO;

public interface EmployeeService {
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    public EmployeeDTO getEmployeeById(Long empId);
}
