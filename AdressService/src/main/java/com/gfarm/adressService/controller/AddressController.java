package com.gfarm.adressService.controller;

import com.gfarm.adressService.response.AddressResp.AddressReps;
import com.gfarm.adressService.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @PostMapping
    public ResponseEntity<AddressReps> createAddress(@RequestBody AddressReps address){

        AddressReps addressReps = addressService.createAddress(address);

        return ResponseEntity.status(HttpStatus.CREATED).body(addressReps);
    }

    @GetMapping("/add/{id}")
    public ResponseEntity<AddressReps> getAddressByEmpId(@PathVariable Integer id){
            AddressReps addressReps = addressService.getAddress(id);
            return ResponseEntity.status(HttpStatus.OK).body(addressReps);
    }

}

