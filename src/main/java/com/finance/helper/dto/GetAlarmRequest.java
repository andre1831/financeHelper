package com.finance.helper.dto;

import com.finance.helper.entity.UserProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAlarmRequest {
    private UserProduct userProduct;
}

