package com.domain.models.repos;

import java.util.List;

import com.domain.models.entities.Supplier;

import org.springframework.data.repository.CrudRepository;


public interface SupplierRepo extends CrudRepository<Supplier, Long>{
// Derived Query Methods in Spring Data JPA Repositories

    Supplier findByEmail(String email);

    List<Supplier> findByNameContainsOrderByIdDesc(String name);

    List<Supplier> findByNameStartingWith(String prefix);

    List<Supplier> findByNameContainsOrEmailContains(String name, String email);


}
