package com.example.jpafindmultiplefields.controller;

import com.example.jpafindmultiplefields.criteria.CountryCriteria;
import com.example.jpafindmultiplefields.domain.Country;
import com.example.jpafindmultiplefields.service.CountryService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/countries")
@RestController
public class CountryController {

    private final CountryService countryService;

    @RequestMapping
    public ResponseEntity<Page<Country>> list(CountryCriteria criteria, Pageable pageable) {
        Page<Country> page = countryService.list(criteria, pageable);
        return ResponseEntity.ok(page);
    }

}
