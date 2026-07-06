package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

/**
 * Hands on 2 - REST - Country Web Service / Get all countries / Get country based on country code
 * Hands on 4 - RESTful naming conventions: "/countries" plural resource name,
 *              @PostMapping to create a country, @Valid for bean validation.
 *
 * NOTE: no class-level @RequestMapping is used here so that both the original
 * "/country" (single India resource, Hands on 2) and the REST-compliant
 * "/countries" (Hands on 2 & 4) endpoints can be demonstrated side by side.
 */
@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    /**
     * Hands on 2 - REST - Country Web Service
     * GET /country -> returns hard-coded India country bean loaded from country.xml
     */
    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START");
        Country country = countryService.getCountryIndia();
        LOGGER.info("END");
        return country;
    }

    /**
     * Hands on 2 - GET /countries -> returns all countries
     */
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("START");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.info("END");
        return countries;
    }

    /**
     * Hands on 2 - GET /countries/{code} -> returns a specific country (case insensitive)
     * Throws CountryNotFoundException (mapped to 404) if the code does not exist.
     */
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START");
        LOGGER.debug("code : {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END");
        return country;
    }

    /**
     * Hands on 4 - POST /countries -> create a country.
     * @Valid triggers bean validation defined in Country class (delegated to
     * GlobalExceptionHandler for error responses).
     */
    @PostMapping("/countries")
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("START");
        LOGGER.debug("country : {}", country);
        LOGGER.info("END");
        return country;
    }
}
