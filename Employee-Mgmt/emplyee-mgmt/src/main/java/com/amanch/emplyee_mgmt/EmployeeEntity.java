package com.amanch.emplyee_mgmt;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="emp_DB")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id ;
    private String name;
    private String contact;
    private String email;
    
}
