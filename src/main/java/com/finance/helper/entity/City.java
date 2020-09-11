package com.finance.helper.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {

    @Id
    private int id;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country countryid;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setCountryid(Country countryid) {
        this.countryid = countryid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Country getCountryid() {
        return countryid;
    }

    public String getName() {
        return name;
    }
}
