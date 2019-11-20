package com.huucong.repository;

import com.huucong.model.Department;
import com.huucong.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
    Iterable<Employee> findAllByDepartment(Department department);

    Page<Employee> findAllByDepartment(Department department, Pageable pageable);

    Page<Employee> findAllByOrderBySalaryAsc(Pageable pageable);
    Page<Employee> findAllByOrderBySalaryDesc(Pageable pageable);
}
