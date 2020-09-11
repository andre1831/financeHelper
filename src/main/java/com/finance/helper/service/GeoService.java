package com.finance.helper.service;

import com.finance.helper.entity.City;
import com.finance.helper.entity.Country;
import com.finance.helper.repository.CityRepository;
import com.finance.helper.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeoService {
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    CityRepository cityRepository;

    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    public List<City> getCityByCountryid(int countryid){
        Country country = countryRepository.getOne(countryid);
        return cityRepository.findCitiesByCountryid(country);
    }
}
