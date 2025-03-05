package com.ars.ems_backend.service;

import com.ars.ems_backend.dto.EmployeeDto;

import java.util.List;


public interface EmployeeService {

    EmployeeDto addEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees();

}
