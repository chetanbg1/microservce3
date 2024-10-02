package com.gfarm.employeeService.service;

import com.gfarm.employeeService.entities.Employee;
import com.gfarm.employeeService.response.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public EmployeeResponse getEmployeeById(Integer id);

    public List<EmployeeResponse> getAllEmployees();

    public EmployeeResponse ceateEmployee(EmployeeResponse emp);
}
