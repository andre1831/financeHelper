package com.finance.helper.service;

import com.finance.helper.entity.Investor;
import com.finance.helper.dto.NewInvestorRequest;
import com.finance.helper.mapper.NewInvestorRequestMapper;
import com.finance.helper.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.finance.helper.Exceptions.FinanceHelperBussinessException;

@Service
public class InvestorService {
    @Autowired
    private InvestorRepository investorRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private NewInvestorRequestMapper mapper;


    public Investor createInvestor(NewInvestorRequest request) throws FinanceHelperBussinessException {
        Investor investor = new Investor();
        try {
            investor = mapper.map(request);
            String encodedPassword = bCryptPasswordEncoder.encode(investor.getPassword());
            investor.setPassword(encodedPassword);
            investor = investorRepository.save(investor);
        }catch (Exception e){
            throw new FinanceHelperBussinessException("error");
        }
        return investor;
    }

    public Investor getInvestorByemail(String email){
        return investorRepository.findByEmail(email);
    }
}
