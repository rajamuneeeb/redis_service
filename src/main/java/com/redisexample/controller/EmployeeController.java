package com.redisexample.controller;

import com.redisexample.entity.Employee;
import com.redisexample.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void saveEmployee(@RequestBody Employee employee) {
        log.info("Saving employee {}", employee);
        employeeService.saveEmployeeInRedis(employee);
    }

    @GetMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Employee> getEmployee(@PathVariable Integer employeeId) {
        log.info("Get Employee By id {}", employeeId);
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee(@RequestBody Employee employee) {
        log.info("Update Employee emp {} ", employee);
        employeeService.updateEmployeeInRedis(employee);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Map<Integer, Employee> getAllEmployees() {
        log.info("Get All Employees");
        return employeeService.getAllEmployees();
    }

    @PostMapping("/saveAll")
    @ResponseStatus(HttpStatus.OK)
    public void saveAll(@RequestBody Map<Integer, Employee> employeeMap) {
        log.info("Save All employee map {} ", employeeMap);
        employeeService.saveAllEmployeeInRedis(employeeMap);
    }

}
