package com.finance.helper.service;

import com.finance.helper.dto.AddAlarmRequest;
import com.finance.helper.dto.DeleteAlarmRequest;
import com.finance.helper.dto.GetAlarmRequest;
import com.finance.helper.dto.ManageProductRequest;
import com.finance.helper.entity.Alarm;
import com.finance.helper.mapper.AddAlarmRequestToAlarmMapper;
import com.finance.helper.repository.AlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmService {
    //job para notificar
    @Autowired
    AlarmRepository alarmRepository;
    @Autowired
    AddAlarmRequestToAlarmMapper addAlarmRequestToAlarmMapper;

    public List<Alarm> createAlarm(AddAlarmRequest request){
        alarmRepository.saveAndFlush(addAlarmRequestToAlarmMapper.map(request));
        return  alarmRepository.findAlarmByUserProduct(request.getUserProduct());
    }

    public List<Alarm> getAlarms(GetAlarmRequest request){
        return alarmRepository.findAlarmByUserProduct(request.getUserProduct());
    }

    public List<Alarm> deleteAlarm(DeleteAlarmRequest request){
        alarmRepository.delete(request.getAlarm());
        alarmRepository.flush();
        return  alarmRepository.findAlarmByUserProduct(request.getAlarm().getUserProduct());
    }
}
