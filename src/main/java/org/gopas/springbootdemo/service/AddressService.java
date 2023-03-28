package org.gopas.springbootdemo.service;

import org.gopas.springbootdemo.data.model.Address;
import org.gopas.springbootdemo.data.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {

        this.addressRepository = addressRepository;
    }

    public Address findById(final Long id) {
        return addressRepository.findById(id).orElseThrow();
    }
}
