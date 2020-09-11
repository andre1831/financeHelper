package com.finance.helper.security;

import com.finance.helper.entity.Investor;
import com.finance.helper.repository.InvestorRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private InvestorRepository investorRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailsServiceImpl(InvestorRepository investorRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.investorRepository = investorRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Investor applicationUser = investorRepository.findByEmail(email);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(email);
        }
        return new User(applicationUser.getEmail(), applicationUser.getPassword(), emptyList());
    }
}
