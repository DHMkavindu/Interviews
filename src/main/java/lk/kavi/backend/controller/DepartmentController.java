package lk.kavi.backend.controller;

import lk.kavi.backend.entity.Department;
import lk.kavi.backend.model.DepartmentDto;
import lk.kavi.backend.service.DepartmentService;
import lk.kavi.backend.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    private final EmployeeService employeeService;

    public DepartmentController(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<DepartmentDto> getDepartment() {
        return departmentService.getAllDepartment();
    }

}
