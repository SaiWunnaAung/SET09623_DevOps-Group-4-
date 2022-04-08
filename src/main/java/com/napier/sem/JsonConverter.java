package com.napier.sem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.napier.sem.model.CapitalCity;
import com.napier.sem.model.City;
import com.napier.sem.model.Country;
import com.napier.sem.model.Population;

import java.util.ArrayList;

/**
 * This class is for JSON converter
 */
public class JsonConverter {
    /**
     * This function is for countryJSON.
     * @param countries
     * @return JSON
     * @throws JsonProcessingException
     */
    public String countryJSON(ArrayList<Country> countries) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(countries);
        return json;
    }

    /**
     * This function is for cityJSON.
     * @param cities
     * @return JSON
     * @throws JsonProcessingException
     */
    public String cityJSON(ArrayList<City> cities) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(cities);
        return json;
    }

    /**
     * This function is for capitalCityJSON.
     * @param capitalCity
     * @return JSON
     * @throws JsonProcessingException
     */
    public String capitalCityJSON(ArrayList<CapitalCity> capitalCity) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(capitalCity);
        return json;
    }

    /**
     * This function is for populationJSON.
     * @param population
     * @return JSON
     * @throws JsonProcessingException
     */
    public String populationJSON(ArrayList<Population> population) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(population);
        return json;
    }

    /**
     * This function is for simplePopulationJSON.
     * @param populations
     * @return JSON
     * @throws JsonProcessingException
     */
    public String simplePopulationJSON(ArrayList<Population> populations) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(populations);
        return json;
    }

    /**
     * This function is for advancePopulationJSON.
     * @param populations
     * @return JSON
     * @throws JsonProcessingException
     */
    public String advancePopulationJSON(ArrayList<Population> populations) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(populations);
        return json;
    }

}
