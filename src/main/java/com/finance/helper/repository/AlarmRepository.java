package com.finance.helper.repository;

import com.finance.helper.entity.Alarm;
import com.finance.helper.entity.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm,Integer> {

    List<Alarm> findAlarmByUserProduct(UserProduct userProduct);
}
