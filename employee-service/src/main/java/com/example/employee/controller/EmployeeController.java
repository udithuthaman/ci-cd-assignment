package com.example.employee.controller;

import com.example.employee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private Map<Long, Employee> employeeDB = new HashMap<>();
    private Long idCounter = 1L;

    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeDB.values();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(idCounter++);
        employeeDB.put(employee.getId(), employee);
        return employee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        if (employeeDB.containsKey(id)) {
            employee.setId(id);
            employeeDB.put(id, employee);
            return employee;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeDB.remove(id);
        return "Deleted employee with ID " + id;
    }
}
