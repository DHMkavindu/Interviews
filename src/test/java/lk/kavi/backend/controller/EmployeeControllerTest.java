package lk.kavi.backend.controller;

import lk.kavi.backend.entity.Department;
import lk.kavi.backend.entity.Employees;
import lk.kavi.backend.model.EmployeesDto;
import lk.kavi.backend.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    void setup(){
        employeeController = new EmployeeController(employeeService);
    }

    @Test
    void createEmployee() {
        Employees employees = new Employees();
        employees.setEmpId(Long.parseLong("3"));
        employees.setFirstName("Amal");
        employees.setLastName("Kumara");

        Mockito.when(employeeService.saveEmployee(employees)).thenReturn(employees);
        ResponseEntity<Object> response = employeeController.createEmployee(employees);
        assertEquals(response.getStatusCode().value(),200);
    }

    @Test
    void getAllEmployee() {
        List<EmployeesDto> employeesDtoList = new ArrayList<>();
        employeesDtoList.add(new EmployeesDto(Long.parseLong("1"),"Kavindu","Dilshan","IT"));
        employeesDtoList.add(new EmployeesDto(Long.parseLong("2"),"Lavindu","Lakshan","HR"));
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeesDtoList);
        List<EmployeesDto> allEmployee = employeeController.getAllEmployee();
        assertNotNull(allEmployee);
    }

    @Test
    void deleteClient() {
        ResponseEntity response = employeeController.deleteEmployee(Long.parseLong("1"));
        assertEquals(response.getStatusCode().value(),200);
    }

    @Test
    void updateEmployee() {
        Employees employees = new Employees();
        employees.setEmpId(Long.parseLong("3"));
        employees.setFirstName("Amal");
        employees.setLastName("Kamal");
        Mockito.when(employeeService.updateEmployee(Long.parseLong("3"), employees)).thenReturn(employees);
        ResponseEntity response = employeeController.updateEmployee(Long.parseLong("3"), employees);
        assertEquals(response.getStatusCode().value(),200);
    }
}