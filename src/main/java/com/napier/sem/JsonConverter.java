package com.napier.sem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.napier.sem.model.CapitalCity;
import com.napier.sem.model.City;
import com.napier.sem.model.Country;
import com.napier.sem.model.Population;

import java.util.ArrayList;

public class JsonConverter {
    public String countryJSON(ArrayList<Country> countries) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(countries);
        return json;
    }
    public String cityJSON(ArrayList<City> cities) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(cities);
        return json;
    }

    public String capitalCityJSON(ArrayList<CapitalCity> capitalCity) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(capitalCity);
        return json;
    }

    public String populationJSON(ArrayList<Population> population) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(population);
        return json;
    }

    public String simplePopulationJSON(ArrayList<Population> populations) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(populations);
        return json;
    }

    public String advancePopulationJSON(ArrayList<Population> populations) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(populations);
        return json;
    }

}
