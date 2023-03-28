package org.gopas.springbootdemo.data.repository;

import org.gopas.springbootdemo.data.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AddressRepository extends JpaRepository<Address, Long> {

}
