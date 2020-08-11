package com.allfirst.common.service;

import com.allfirst.common.domain.Employee;

public interface EmployeeService {
    Employee getEmp(Integer id);
    Employee updateEmp(Employee employee);
    void deleteEmp(Integer id);
    Employee getEmpByLastName(String lastName);
}
