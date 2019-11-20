package com.huucong.service;

import com.huucong.model.Department;
import com.huucong.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Employee findById(int id);

    void save(Employee employee);

    void remove(int id);

    Iterable<Employee> findAllByDepartment(Department department);

    Page<Employee> findAllByDepartment(Department department, Pageable pageable);

    Page<Employee> findAllByOrderBySalaryAsc(Pageable pageable);
    Page<Employee> findAllByOrderBySalaryDesc(Pageable pageable);
}
