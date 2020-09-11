package com.finance.helper.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Setter;


@Setter
public class ProductInfo {

    @SerializedName("Global Quote")
    private GlobalQuote globalQuote;

    public GlobalQuote getGlobalQuote() {
        return globalQuote;
    }
}
