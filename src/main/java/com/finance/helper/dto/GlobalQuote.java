package com.finance.helper.dto;


import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GlobalQuote {

    @SerializedName("01. symbol")
    private String symbol;

    @SerializedName("02. open")
    private float open;

    @SerializedName("03. high")
    private float high;

    @SerializedName("04. low")
    private float low;

    @SerializedName("05. price")
    private float price;

    @SerializedName("06. volume")
    private float volume;

    @SerializedName("07. latest trading day")
    private Date latestTradingDate;

    @SerializedName("08. previous close")
    private float previousClose;

    @SerializedName("09. change")
    private float change;


}
