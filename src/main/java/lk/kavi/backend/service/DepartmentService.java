package lk.kavi.backend.service;

import lk.kavi.backend.entity.Department;
import lk.kavi.backend.model.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    public boolean saveDepartment(Department department);

    public List<DepartmentDto> getAllDepartment();
}
