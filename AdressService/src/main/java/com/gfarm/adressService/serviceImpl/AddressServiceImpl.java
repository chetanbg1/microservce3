package com.gfarm.adressService.serviceImpl;

import com.gfarm.adressService.entities.Address;
import com.gfarm.adressService.repository.AddressRepo;
import com.gfarm.adressService.response.AddressResp.AddressReps;
import com.gfarm.adressService.services.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public AddressReps createAddress(AddressReps address) {

        Address address1 = modelMapper.map(address , Address.class);
        Address  address2 =addressRepo.save(address1);
        return modelMapper.map(address2 , AddressReps.class);
    }

    @Override
    public AddressReps getAddress(int id) {

        Address address = addressRepo.findById(id).get();
        return modelMapper.map(address , AddressReps.class);
    }
}
