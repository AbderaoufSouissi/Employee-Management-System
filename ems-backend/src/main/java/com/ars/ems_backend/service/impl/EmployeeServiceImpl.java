package com.ars.ems_backend.service.impl;

import com.ars.ems_backend.dto.EmployeeDto;
import com.ars.ems_backend.entity.Employee;
import com.ars.ems_backend.exception.ResourceAlreadyExistsException;
import com.ars.ems_backend.exception.ResourceNotFoundException;
import com.ars.ems_backend.repository.EmployeeRepository;
import com.ars.ems_backend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    public List<EmployeeDto> getAllEmployees() {
        if (employeeRepository.findAll().isEmpty()) {
            throw new ResourceNotFoundException("No Employees found");
        }
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employee -> new EmployeeDto(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getEmail())
                )
                .toList();

    }
}
