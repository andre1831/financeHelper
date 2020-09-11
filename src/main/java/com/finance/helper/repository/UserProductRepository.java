package com.finance.helper.repository;

import com.finance.helper.entity.Investor;
import com.finance.helper.entity.Product;
import com.finance.helper.entity.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProductRepository extends JpaRepository<UserProduct,Integer> {

    List<UserProduct> findByInvestor(Investor investor);
}
