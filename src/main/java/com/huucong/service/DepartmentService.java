package com.huucong.service;

import com.huucong.model.Department;

public interface DepartmentService {
    Iterable<Department> findAll();

    Department findById(int id);

    void save(Department department);

    void remove(int id);
}
