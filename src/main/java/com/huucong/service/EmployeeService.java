package com.huucong.service;

import com.huucong.model.Department;
import com.huucong.model.Employee;

public interface EmployeeService {
    Iterable<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void remove(int id);

    Iterable<Employee> findAllByDepartment(Department department);

}
