package com.finance.helper.mapper;


import com.finance.helper.entity.Investor;
import com.finance.helper.dto.NewInvestorRequest;
import com.finance.helper.utils.Mapper;
import org.springframework.stereotype.Component;

@Component
public class NewInvestorRequestMapper implements Mapper<NewInvestorRequest, Investor> {
    @Override
    public Investor map(NewInvestorRequest target) {
        Investor investor=new Investor();
        investor.setName(target.getName());
        investor.setCountry(target.getCountry());
        investor.setCity(target.getCity());
        investor.setAdress(target.getAdress());
        investor.setEmail(target.getEmail());
        investor.setGender(target.getGender());
        investor.setBirthdate(target.getBirthdate());
        investor.setZipcode(target.getZipcode());
        investor.setPassword(target.getPassword());

        return investor;
    }
}
