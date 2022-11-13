package lk.kavi.backend.service.Impl;

import lk.kavi.backend.entity.Department;
import lk.kavi.backend.model.DepartmentDto;
import lk.kavi.backend.repository.DepartmentRepository;
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
class DepartmentServiceImplTest {


    private DepartmentServiceImpl departmentService;

    @Mock
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setup(){
       departmentService = new DepartmentServiceImpl(departmentRepository);
    }

    @Test
    void getAllDepartment() {
        List<Department> departmentList = new ArrayList<>();
        departmentList.add(new Department());
        departmentList.add(new Department());
        Mockito.when(departmentRepository.findAll()).thenReturn(departmentList);
        List<DepartmentDto> allDepartment = departmentService.getAllDepartment();
        assertNotNull(allDepartment);
    }
}