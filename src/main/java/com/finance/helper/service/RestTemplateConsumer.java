package com.finance.helper.service;

import com.finance.helper.dto.ProductInfo;
import com.finance.helper.utils.ApiCaller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Service
public class RestTemplateConsumer implements AlphaVantageService {

    private static final String BASE_URL = "https://www.alphavantage.co/";
    @Value("${apikey}")
    private String apiKey;
    @Value("${getProductFunction}")
    private String function;

    @Override
    public ProductInfo getProductInfo(String symbol) throws Exception {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiCaller requestClient = retrofit.create(ApiCaller.class);

        Call<ProductInfo> call = requestClient.getReadyToPay(apiKey,symbol,function);
        Response<ProductInfo> execute = call.execute();
        ProductInfo productInfo = execute.body();


        return productInfo;
    }
}
