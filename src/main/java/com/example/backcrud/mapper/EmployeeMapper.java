package com.example.backcrud.mapper;

import com.example.backcrud.dto.EmployeeDto;
import com.example.backcrud.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {


    public EmployeeDto toEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = EmployeeDto.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();
        BeanUtils.copyProperties(employee, employeeDto);
        return employeeDto;
    }

    public Employee toEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        return employee;
    }
}
