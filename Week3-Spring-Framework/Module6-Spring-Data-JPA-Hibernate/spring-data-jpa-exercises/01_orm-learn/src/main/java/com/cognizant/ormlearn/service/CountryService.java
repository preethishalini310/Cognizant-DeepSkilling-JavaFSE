package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service for Country CRUD and Query Methods.
 *
 * FILE 1 – Hands-on 1  : getAllCountries
 * FILE 1 – Hands-on 6  : findCountryByCode
 * FILE 1 – Hands-on 7  : addCountry
 * FILE 1 – Hands-on 8  : updateCountry
 * FILE 1 – Hands-on 9  : deleteCountry
 * FILE 2 – Hands-on 1  : findCountriesContaining, findCountriesStartingWith
 */
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // ── FILE 1 – Hands-on 1 ──────────────────────────────────────────────────
    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // ── FILE 1 – Hands-on 6 ──────────────────────────────────────────────────
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found for code: " + countryCode);
        }
        return result.get();
    }

    // ── FILE 1 – Hands-on 7 ──────────────────────────────────────────────────
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // ── FILE 1 – Hands-on 8 ──────────────────────────────────────────────────
    @Transactional
    public void updateCountry(String code, String newName) {
        Optional<Country> result = countryRepository.findById(code);
        if (result.isPresent()) {
            Country country = result.get();
            country.setName(newName);
            countryRepository.save(country);
        }
    }

    // ── FILE 1 – Hands-on 9 ──────────────────────────────────────────────────
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    // ── FILE 2 – Hands-on 1: Query Methods ───────────────────────────────────

    /** Search countries by partial name (case-insensitive), sorted A-Z */
    @Transactional
    public List<Country> findCountriesContaining(String text) {
        return countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(text);
    }

    /** Countries whose name starts with a given letter */
    @Transactional
    public List<Country> findCountriesStartingWith(String letter) {
        return countryRepository.findByNameStartingWith(letter);
    }
}
