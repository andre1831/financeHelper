package com.finance.helper.dto;

import com.finance.helper.entity.City;
import com.finance.helper.entity.Country;
import com.finance.helper.entity.Gender;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


public class NewInvestorRequest {


    private String name;

    public NewInvestorRequest(String name, String email, String adress, String zipcode, String password, Country country, City city, Gender gender, Date birthdate) {
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.zipcode = zipcode;
        this.password = password;
        this.country = country;
        this.city = city;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    private String email;
    private String adress;
    private String zipcode;
    private String password;
    private Country country;
    private City city;
    private Gender gender;
    private Date birthdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
