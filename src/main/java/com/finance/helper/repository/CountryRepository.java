package com.finance.helper.repository;

import com.finance.helper.entity.Country;
import com.finance.helper.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
}
