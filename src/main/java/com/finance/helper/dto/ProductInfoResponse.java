package com.finance.helper.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ProductInfoResponse {


    private String symbol;

    private float open;
    private float high;

    private float low;

    private float price;

    private float volume;

    private Date latestTradingDate;

    private float previousClose;

    private float change;

}
