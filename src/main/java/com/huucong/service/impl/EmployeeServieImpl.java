package com.huucong.service.impl;

import com.huucong.model.Department;
import com.huucong.model.Employee;
import com.huucong.repository.EmployeeRepository;
import com.huucong.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class EmployeeServieImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
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

    @Override
    public Page<Employee> findAllByDepartment(Department department, Pageable pageable) {
        return employeeRepository.findAllByDepartment(department,pageable);
    }

    @Override
    public Page<Employee> findAllByOrderBySalaryAsc(Pageable pageable) {
        return employeeRepository.findAllByOrderBySalaryAsc(pageable);
    }

    @Override
    public Page<Employee> findAllByOrderBySalaryDesc(Pageable pageable) {
        return employeeRepository.findAllByOrderBySalaryDesc(pageable);
    }
}
