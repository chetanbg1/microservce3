package com.gfarm.employeeService.controller;

import com.gfarm.employeeService.entities.Employee;
import com.gfarm.employeeService.repository.EmployeeRepo;
import com.gfarm.employeeService.response.EmployeeResponse;
import com.gfarm.employeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EmployeeService employeeService;
//    @GetMapping
//    public String getEmployee(){
//
//        String address = restTemplate.getForObject("http://localhost:8080/address" , String.class);
//        return  "chetan the great " + address;
//    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable int id){

        EmployeeResponse employee = employeeService.getEmployeeById(id);

        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeResponse employeeResponse){
        EmployeeResponse employeeResponse1 = employeeService.ceateEmployee(employeeResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
    }
}
