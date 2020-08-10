package com.allfirst.common.dao;

import com.allfirst.common.domain.Employee;

public interface EmployeeDao {
    Employee getEmpById(Integer id);

    void insertEmp(Employee employee);
}
