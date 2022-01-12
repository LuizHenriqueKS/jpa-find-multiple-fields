package com.example.jpafindmultiplefields.service;

import com.example.jpafindmultiplefields.criteria.CountryCriteria;
import com.example.jpafindmultiplefields.domain.Country;
import com.example.jpafindmultiplefields.repository.CountryRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public Page<Country> list(CountryCriteria criteria, Pageable pageable) {
        return countryRepository.findAll(criteria, pageable);
    }

}
