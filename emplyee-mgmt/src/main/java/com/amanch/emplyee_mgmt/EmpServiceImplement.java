package com.amanch.emplyee_mgmt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class EmpServiceImplement implements EmpService {

    @Autowired
    EmpRepository empRepo;

    // ArrayList<Employees> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employees employee) {
        EmployeeEntity empEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, empEntity);
        empRepo.save(empEntity);
        // employees.add(employee);
        return "Saved Successfully";
    }

    @Override
    public Employees readEmployee(Long id) {
        EmployeeEntity empEntity = empRepo.findById(id).get();
        Employees employee = new Employees();
        BeanUtils.copyProperties(empEntity, employee);
        return employee;
    }

    @Override
    public ArrayList<Employees> readEmployees() {

        List<EmployeeEntity> employeeList = empRepo.findAll();
        ArrayList<Employees> employees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeList){
            Employees emp = new Employees();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setContact(employeeEntity.getContact());
            emp.setEmail(employeeEntity.getEmail());


            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(long id) {
        // employees.remove(id);
        // return true;
        // return employees.removeIf(emp -> emp.getId() == id);
        EmployeeEntity emp = empRepo.findById(id).get();
        empRepo.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employees employee) {
    EmployeeEntity existingEmployee = empRepo.findById(id).get();
    
    existingEmployee.setName(employee.getName());
    existingEmployee.setEmail(employee.getEmail());
    existingEmployee.setContact(employee.getContact());

    empRepo.save(existingEmployee);
    return "Update Success";
    }




}
