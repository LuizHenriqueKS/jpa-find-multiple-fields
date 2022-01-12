package com.example.jpafindmultiplefields.repository;

import com.example.jpafindmultiplefields.criteria.CountryCriteria;
import com.example.jpafindmultiplefields.domain.Country;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@DataJpaTest
@DisplayName("Tests for CountryRepository")
public class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    @DisplayName("findAll returns a countries page when successful")
    void findAll_ReturnsPageCountries_Whensuccessful() {
        Page<Country> countryList = countryRepository.findAll(Pageable.ofSize(10));
        Assertions.assertThat(countryList.getContent()).isNotEmpty();
    }

    @Test
    @DisplayName("findAll returns a filtered countries page when successful")
    void findAll_ReturnsPageCountriesFiltred_Whensuccessful() {
        CountryCriteria criteria = CountryCriteria.builder().nameContains("Brasil").build();
        Page<Country> countryList = countryRepository.findAll(criteria, Pageable.ofSize(10));
        Assertions.assertThat(countryList.getContent()).isNotEmpty();
        Country country = countryList.getContent().get(0);
        Assertions.assertThat(country.getName()).isEqualTo("Brasil");
    }

}
