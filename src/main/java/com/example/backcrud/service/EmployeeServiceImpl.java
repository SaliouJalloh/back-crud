package com.example.backcrud.service;

import com.example.backcrud.dto.EmployeeDto;
import com.example.backcrud.mapper.EmployeeMapper;
import com.example.backcrud.model.Employee;
import com.example.backcrud.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employeeMapper::toEmployeeDto)
                .toList();
    }

    @Override
    public EmployeeDto getEmployeeById(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        return employeeMapper.toEmployeeDto(employee);
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        var employee = employeeMapper.toEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto updateEmployee(Integer id, EmployeeDto employee) {
        Employee updatedEmployee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        updatedEmployee.setFirstName(employee.firstName());
        updatedEmployee.setLastName(employee.lastName());
        updatedEmployee.setEmail(employee.email());
        return employeeMapper.toEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
