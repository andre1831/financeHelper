package com.finance.helper.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class CountryRequest {


    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
