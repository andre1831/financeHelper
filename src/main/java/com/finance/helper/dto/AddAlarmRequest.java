package com.finance.helper.dto;


import com.finance.helper.entity.Attribute;
import com.finance.helper.entity.UserProduct;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddAlarmRequest {
    UserProduct userProduct;
    Attribute attribute;
    float minVal;
    float maxVal;

}
