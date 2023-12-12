package com.redisexample.repository;

import com.redisexample.entity.Employee;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class EmployeeRepositoryImp implements EmployeeRepository {
    private final String hashReference = "Employee";
    @Resource(name = "employeeRedisTemplate")
    private HashOperations<String, Integer, Employee> employeeHashOperations;

    @Override
    public void saveEmployee(Employee employee) {
        employeeHashOperations.putIfAbsent(hashReference, employee.getEmpId(), employee);
    }

    @Override
    public Employee getOneEmployee(Integer id) {
        return employeeHashOperations.get(hashReference, id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeHashOperations.put(hashReference, employee.getEmpId(), employee);

    }

    @Override
    public Map<Integer, Employee> getAllEmployees() {
        return employeeHashOperations.entries(hashReference);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeHashOperations.delete(hashReference, id);

    }

    @Override
    public void saveAllEmployees(Map<Integer, Employee> map) {
        employeeHashOperations.putAll(hashReference, map);
    }
}
