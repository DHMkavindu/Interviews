package lk.kavi.backend.service.Impl;

import lk.kavi.backend.entity.Department;
import lk.kavi.backend.entity.Employees;
import lk.kavi.backend.model.EmployeesDto;
import lk.kavi.backend.repository.DepartmentRepository;
import lk.kavi.backend.repository.EmployeeRepository;
import lk.kavi.backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;


    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Employees saveEmployee(Employees employees) {
        Department department = departmentRepository.findById(employees.getDepartment().getDepId()).get();
        employees.setDepartment(department);
        Employees save = employeeRepository.save(employees);
        return save;
    }

    @Override
    public List<EmployeesDto> getAllEmployees() {
        List<Employees> employeesList = employeeRepository.findAll();
        List<EmployeesDto> employeesDtoList = new ArrayList<>();
        for (Employees employees : employeesList) {
            EmployeesDto employeesDto = new EmployeesDto();

            employeesDto.setEmpId(employees.getEmpId());
            employeesDto.setFirstName(employees.getFirstName());
            employeesDto.setLastName(employees.getLastName());
            employeesDto.setDepName(departmentRepository.findById(employees.getDepartment().getDepId()).get().getDepName());

            employeesDtoList.add(employeesDto);
        }
        return employeesDtoList;
    }

    @Override
    public List<Employees> getEmployeesByDepartmentId() {
        return new ArrayList<Employees>();
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employees updateEmployee(Long id, Employees employee) {
        Employees employees = employeeRepository.findById(id).get();
        employees.setFirstName(employee.getFirstName());
        employees.setLastName(employee.getLastName());
        Department department = departmentRepository.findById(employee.getDepartment().getDepId()).orElse(null);
        employees.setDepartment(department);

        return employeeRepository.save(employees);
    }
}
