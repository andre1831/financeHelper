package com.finance.helper.repository;

import com.finance.helper.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorRepository extends JpaRepository<Investor,Long> {
    Investor findByEmail(String username);
}
