package com.amanch.emplyee_mgmt;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

//    ArrayList<Employees> employees = new ArrayList<>();
    // EmpService empService = new EmpServiceImplement();

    //dependency injection
    @Autowired
   EmpService empService;

    @GetMapping("employee")
    public ArrayList<Employees> getAllEmployees()
    {
        return empService.readEmployees();
    }

    @GetMapping("employee/{id}")
    public Employees readEmployeeByID(@PathVariable Long id)
    {
        return empService.readEmployee(id);
    }

    @PostMapping("employee")
    public String createEmployee(@RequestBody Employees employee)
    {
        return empService.createEmployee(employee);
    }

    @DeleteMapping("employee/{id}")//{} -> path variable
    public String deleteEmployee(@PathVariable long id){
        if (empService.deleteEmployee(id))
            return "Delete Success";
        return "Not Found";
    }

    @PutMapping("employee/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employees employee) {
        return empService.updateEmployee(id, employee);
    }
}