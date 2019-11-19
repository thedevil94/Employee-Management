package com.huucong.service.impl;

import com.huucong.model.Department;
import com.huucong.model.Employee;
import com.huucong.repository.EmployeeRepository;
import com.huucong.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServieImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        employeeRepository.delete(id);
    }

    @Override
    public Iterable<Employee> findAllByDepartment(Department department) {
        return employeeRepository.findAllByDepartment(department);
    }
}
