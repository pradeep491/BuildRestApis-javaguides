package com.test.service.impl;

import com.test.DepartmentServiceApplication;
import com.test.dtos.DepartmentDTO;
import com.test.entity.Department;
import com.test.repos.DepartmentRepository;
import com.test.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final ModelMapper modelMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = modelMapper.map(departmentDTO, Department.class);
        Department savedDepartment = departmentRepository.save(department);
        return modelMapper.map(savedDepartment, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String deptCode) {
        Department department = departmentRepository.findByDeptCode(deptCode);
        return modelMapper.map(department, DepartmentDTO.class);
    }
}
