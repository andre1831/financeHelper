package com.finance.helper.dto;

import com.finance.helper.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class AddProductRequest {
    String username;
    Product product;

    public String getUsername() {
        return username;
    }

    public Product getProduct() {
        return product;
    }
}
