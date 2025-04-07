package com.example.employee.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
	
	
  @Test
  void shouldFail() {
      assertEquals(1, 2);
  }

	

    @Test
    void testEmployeeConstructorAndGetters() {
        Employee emp = new Employee(1L, "Alice", "Developer");

        assertEquals(1L, emp.getId());
        assertEquals("Alice", emp.getName());
        assertEquals("Developer", emp.getRole());
    }

    @Test
    void testEmployeeSetters() {
        Employee emp = new Employee();
        emp.setId(2L);
        emp.setName("Bob");
        emp.setRole("Tester");

        assertEquals(2L, emp.getId());
        assertEquals("Bob", emp.getName());
        assertEquals("Tester", emp.getRole());
    }
    
    
}
