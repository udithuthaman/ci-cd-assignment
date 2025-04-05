package com.example.employee;

import com.example.employee.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testAddAndGetEmployees() {
        Employee employee = new Employee(null, "Alice", "Developer");
        ResponseEntity<Employee> response = restTemplate.postForEntity("/employees", employee, Employee.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody().getId());

        ResponseEntity<Employee[]> listResponse = restTemplate.getForEntity("/employees", Employee[].class);
        assertTrue(Objects.requireNonNull(listResponse.getBody()).length > 0);
    }
    @Test
    void testEmptyList() {
        ResponseEntity<Employee[]> response = restTemplate.getForEntity("/employees", Employee[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
