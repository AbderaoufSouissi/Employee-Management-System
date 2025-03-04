package com.ars.ems_backend;

import com.ars.ems_backend.dto.EmployeeDto;
import com.ars.ems_backend.entity.Employee;
import com.ars.ems_backend.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@Slf4j
@SpringBootApplication
public class EmsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmsBackendApplication.class, args);
	}


}
