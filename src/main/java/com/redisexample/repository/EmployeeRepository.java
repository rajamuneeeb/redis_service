package com.redisexample.repository;

import com.redisexample.entity.Employee;

import java.util.Map;

public interface EmployeeRepository {
    void saveEmployee(Employee employee);

    Employee getOneEmployee(Integer id);

    void updateEmployee(Employee employee);

    Map<Integer, Employee> getAllEmployees();

    void deleteEmployee(Integer id);

    void saveAllEmployees(Map<Integer, Employee> map);

}
