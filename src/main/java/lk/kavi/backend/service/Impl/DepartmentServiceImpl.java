package lk.kavi.backend.service.Impl;

import lk.kavi.backend.entity.Department;
import lk.kavi.backend.model.DepartmentDto;
import lk.kavi.backend.repository.DepartmentRepository;
import lk.kavi.backend.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public boolean saveDepartment(Department department) {
        return false;
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> departmentList = departmentRepository.findAll();
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        for (Department department : departmentList) {
            DepartmentDto departmentDto = new DepartmentDto();
            departmentDto.setDepId(department.getDepId());
            departmentDto.setDepName(department.getDepName());

            departmentDtoList.add(departmentDto);
        }
        return departmentDtoList;
    }
}
