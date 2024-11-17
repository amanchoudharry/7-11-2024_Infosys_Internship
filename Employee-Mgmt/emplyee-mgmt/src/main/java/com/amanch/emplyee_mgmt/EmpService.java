package com.amanch.emplyee_mgmt;

import java.util.ArrayList;

public interface EmpService {
    String createEmployee(Employees employee);
    ArrayList<Employees> readEmployees ();
    boolean deleteEmployee(long id);
    String updateEmployee(Long id,Employees employee);
    Employees readEmployee(Long id);
}