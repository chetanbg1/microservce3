package com.gfarm.employeeService.response;

import lombok.Data;

@Data
public class AddressReps {

    private int id;
    private String lane1;
    private String lane2;
    private String state;
    private String zip;
}
