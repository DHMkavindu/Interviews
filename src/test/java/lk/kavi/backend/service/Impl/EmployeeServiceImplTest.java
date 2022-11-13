package lk.kavi.backend.service.Impl;

import lk.kavi.backend.entity.Employees;
import lk.kavi.backend.model.EmployeesDto;
import lk.kavi.backend.repository.DepartmentRepository;
import lk.kavi.backend.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setup(){
        employeeService = new EmployeeServiceImpl(employeeRepository,departmentRepository);
    }
    @Test
    void saveEmployee() {
        Employees employees = new Employees();
        employees.setFirstName("Amal");
        employees.setLastName("Kumara");


        Employees employee = new Employees();
        employees.setEmpId(Long.parseLong("3"));
        employees.setFirstName("Amal");
        employees.setLastName("Kumara");

        Mockito.when(employeeRepository.save(employees)).thenReturn(employee);
        Employees employeesResult = employeeService.saveEmployee(employees);
        assertNotNull(employeesResult);
    }

    @Test
    void getAllEmployees() {
        List<Employees> employeesList = new ArrayList<>();
        employeesList.add(new Employees());
        employeesList.add(new Employees());
        employeesList.add(new Employees());

        Mockito.when(employeeRepository.findAll()).thenReturn(employeesList);
        List<EmployeesDto> allEmployees = employeeService.getAllEmployees();
        assertNotNull(allEmployees);
    }


    @Test
    void deleteById() {
        employeeService.deleteById(Long.parseLong("3"));
    }

    @Test
    void updateEmployee() {
        Employees employee = new Employees();
        employee.setEmpId(Long.parseLong("3"));
        employee.setFirstName("Amal");
        employee.setLastName("Kamal");



        Mockito.when(employeeRepository.findById(Long.parseLong("3"))).thenReturn(Optional.of(employee));
//        Mockito.when(departmentRepository.findById(Long.parseLong("1"))).thenReturn(Optional.of(department));
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        Employees employees = employeeService.updateEmployee(Long.parseLong("3"), employee);
        assertEquals(employees.getEmpId(),3);
    }
}