package com.gfarm.adressService.repository;

import com.gfarm.adressService.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address , Integer> {
}
