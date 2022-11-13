package lk.kavi.backend.service;

import lk.kavi.backend.entity.Employees;
import lk.kavi.backend.model.EmployeesDto;

import java.util.List;

public interface EmployeeService {

    Employees saveEmployee(Employees employees);

    List<EmployeesDto> getAllEmployees();

    List<Employees> getEmployeesByDepartmentId();

    void deleteById(Long id);

    Employees updateEmployee(Long id, Employees employee);
}
