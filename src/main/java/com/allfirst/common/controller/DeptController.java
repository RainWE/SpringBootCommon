package com.allfirst.common.controller;


import com.allfirst.common.dao.DepartmentDao;
import com.allfirst.common.dao.EmployeeDao;
import com.allfirst.common.domain.Department;
import com.allfirst.common.domain.Employee;
import com.allfirst.common.service.DepartmentService;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
/*
    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        System.out.println(departmentDao.getDeptById(id));
        return departmentDao.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentDao.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){

        return employeeDao.getEmpById(id);
    }
*/
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return departmentService.getDeptById(id);
    }
}
