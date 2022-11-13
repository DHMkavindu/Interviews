package lk.kavi.backend.controller;

import lk.kavi.backend.model.DepartmentDto;
import lk.kavi.backend.service.DepartmentService;
import lk.kavi.backend.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentControllerTest {

    private DepartmentController departmentController;
    @Mock
    private DepartmentService departmentService;

    @Mock
    private  EmployeeService employeeService;

    @BeforeEach
    void setup(){
        departmentController = new DepartmentController(departmentService,employeeService);
    }

    @Test
    void getDepartment() {
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        departmentDtoList.add(new DepartmentDto(Long.parseLong("1"),"IT"));
        departmentDtoList.add(new DepartmentDto(Long.parseLong("2"),"HR"));

        Mockito.when(departmentService.getAllDepartment()).thenReturn(departmentDtoList);
        List<DepartmentDto> department = departmentController.getDepartment();
       assertNotNull(department);

    }
}