package com.finance.helper.utils;


import com.finance.helper.dto.ProductInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCaller {

    @GET("query?")
    Call<ProductInfo> getReadyToPay(@Query("apikey") String apikey, @Query("symbol") String symbol, @Query("function") String function);
}
