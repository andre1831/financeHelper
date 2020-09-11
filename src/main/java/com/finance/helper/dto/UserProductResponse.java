package com.finance.helper.dto;

import com.finance.helper.entity.UserProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProductResponse {
    UserProduct userProduct;
    GlobalQuote globalQuote;

}
