package com.finance.helper.mapper;

import com.finance.helper.dto.AddAlarmRequest;
import com.finance.helper.entity.Alarm;
import com.finance.helper.utils.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AddAlarmRequestToAlarmMapper implements Mapper<AddAlarmRequest, Alarm> {
    @Override
    public Alarm map(AddAlarmRequest target) {

        return Alarm.builder().attribute(target.getAttribute()).userProduct(target.getUserProduct()).maxval(target.getMaxVal()).minval(target.getMinVal()).build();
    }
}
