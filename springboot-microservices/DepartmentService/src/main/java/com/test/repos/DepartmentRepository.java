package com.test.repos;

import com.test.dtos.DepartmentDTO;
import com.test.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByDeptCode(String deptCode);
}
