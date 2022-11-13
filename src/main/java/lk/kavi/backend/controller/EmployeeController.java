package lk.kavi.backend.controller;

import lk.kavi.backend.entity.Employees;
import lk.kavi.backend.model.EmployeesDto;
import lk.kavi.backend.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping
    public ResponseEntity<Object> createEmployee(@RequestBody Employees employees) {
        return ResponseEntity.ok(employeeService.saveEmployee(employees));
    }

    @GetMapping
    public List<EmployeesDto> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateEmployee(@PathVariable Long id, @RequestBody Employees employee) {
        Employees employees = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(employees);
    }
}
