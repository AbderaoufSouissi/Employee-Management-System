package com.ars.ems_backend.entity;


import jakarta.persistence.*;
import lombok.*;


@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
@Entity
@Table(name = "employees")
public class Employee {
    @Id @GeneratedValue
    @Column(name = "employee_id")
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true,nullable = false)
    private String email;
}
