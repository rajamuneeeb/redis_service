package com.redisexample.service;

import com.redisexample.entity.Employee;
import com.redisexample.repository.EmployeeRepositoryImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepositoryImp employeeRepositoryImp;

    public void saveEmployeeInRedis(Employee employee) {
        log.info("Employee Service employee {} ", employee);
        if (employee != null) {
            employeeRepositoryImp.saveEmployee(employee);
        }
    }

    public Optional<Employee> getEmployeeById(Integer employeeId) {
        log.info("Employee Service empId {}", employeeId);
        if (employeeId != null) {
            return Optional.ofNullable(employeeRepositoryImp.getOneEmployee(employeeId));
        }
        return Optional.empty();
    }

    public void updateEmployeeInRedis(Employee employee) {
        log.info("Employee Service Update emp {} ", employee);
        if (employee != null) {
            employeeRepositoryImp.updateEmployee(employee);
        }
    }

    public Map<Integer, Employee> getAllEmployees() {
        log.info("Employee Service Get All Employees");
        return employeeRepositoryImp.getAllEmployees();
    }

    public void saveAllEmployeeInRedis(Map<Integer, Employee> employeeMap) {
        log.info("Saving All employees in service empMap {}", employeeMap);
        employeeRepositoryImp.saveAllEmployees(employeeMap);
    }
}
