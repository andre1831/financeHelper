package com.finance.helper.service;


import com.finance.helper.dto.ProductInfo;

public interface AlphaVantageService {
    ProductInfo getProductInfo(String symbol) throws Exception;
}
