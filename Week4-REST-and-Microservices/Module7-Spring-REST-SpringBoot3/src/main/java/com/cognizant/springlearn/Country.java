package com.cognizant.springlearn;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hands on 4 - Spring Core - Load Country from Spring Configuration XML
 * Hands on 4 (validation) - Country code should be exactly 2 characters
 */
public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    @NotNull
    @Size(min = 2, max = 2, message = "Country code should be 2 characters")
    private String code;

    @NotNull
    @NotBlank
    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        LOGGER.debug("getCode() : {}", code);
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("setCode() : {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("getName() : {}", name);
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("setName() : {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
