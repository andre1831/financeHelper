package com.finance.helper.mapper;

import com.finance.helper.dto.AddProductRequest;
import com.finance.helper.entity.Investor;
import com.finance.helper.entity.UserProduct;
import com.finance.helper.repository.InvestorRepository;
import com.finance.helper.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddProductRequestMapper implements Mapper<AddProductRequest, UserProduct> {

    @Autowired
    InvestorRepository investorRepository;

    @Override
    public UserProduct map(AddProductRequest target) {
        return UserProduct.builder().product(target.getProduct()).investor(getInvestor(target.getUsername())).build();
    }

    private Investor getInvestor(String email){
        return investorRepository.findByEmail(email);

    }
}
