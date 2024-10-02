package com.gfarm.employeeService.response;

import lombok.Data;

@Data
public class EmployeeResponse {

    private Integer id;
    private String name;
    private String email;
    private String bloodGroup;
    private AddressReps addressReps;
}
