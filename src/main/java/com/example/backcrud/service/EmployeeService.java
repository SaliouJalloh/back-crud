package com.example.backcrud.service;

import com.example.backcrud.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getEmployees();
    EmployeeDto getEmployeeById(Integer id);
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto);
    void deleteEmployee(Integer id);
}
