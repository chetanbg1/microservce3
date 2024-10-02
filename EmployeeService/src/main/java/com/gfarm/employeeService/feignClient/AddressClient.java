package com.gfarm.employeeService.feignClient;

import com.gfarm.employeeService.response.AddressReps;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ADRESSSERVICE") // url = "http://localhost:8080"
public interface AddressClient {

    //http://localhost:8080/address/add/1
    @GetMapping("/address/add/1")
   public AddressReps getAddressById();
}
