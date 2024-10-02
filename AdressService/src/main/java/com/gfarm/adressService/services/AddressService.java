package com.gfarm.adressService.services;

import com.gfarm.adressService.response.AddressResp.AddressReps;

public interface AddressService {

    public AddressReps createAddress(AddressReps address);
    public AddressReps getAddress(int id);
}
