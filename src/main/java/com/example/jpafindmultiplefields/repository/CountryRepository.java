package com.example.jpafindmultiplefields.repository;

import com.example.jpafindmultiplefields.domain.Country;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long>, JpaSpecificationExecutor<Country> {

    Page<Country> findAll(Pageable pageable);

}
