package com.ars.ems_backend.service.impl;

import com.ars.ems_backend.dto.EmployeeDto;
import com.ars.ems_backend.entity.Employee;
import com.ars.ems_backend.exception.ResourceAlreadyExistsException;
import com.ars.ems_backend.repository.EmployeeRepository;
import com.ars.ems_backend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        if(employeeRepository.existsByEmail(employeeDto.email())){
            throw new ResourceAlreadyExistsException("Employee Already Exists");
        }
        Employee newEmployee = Employee.builder()
                .firstName(employeeDto.firstName())
                .lastName(employeeDto.lastName())
                .email(employeeDto.email())
                .build();
        employeeRepository.save(newEmployee);

        return employeeDto;

    }
}
