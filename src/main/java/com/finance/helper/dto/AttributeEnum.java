package com.finance.helper.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Setter;

import java.util.Date;


public enum AttributeEnum {

    OPEN("open"),
    HIGH("high"),
    LOW("low"),
    PRICE("price"),
    VOLUME("volume"),
    PREVIOUSCLOSE("previousClose"),
    CHANGE("change");

    private final String value;

    AttributeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
