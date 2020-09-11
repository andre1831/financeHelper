package com.finance.helper.batch;

import com.finance.helper.entity.Alarm;
import com.finance.helper.dto.GlobalQuote;
import com.finance.helper.dto.ProductInfo;
import com.finance.helper.repository.AlarmRepository;
import com.finance.helper.service.AlphaVantageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmProcess  {

    private static final String OPEN = "open";
    private static final String HIGH = "high";
    private static final String LOW="low";
    private static final String PRICE="price";
    private static final String VOLUME="volume";
    private static final String CHANGE="change";

    @Autowired
    AlarmRepository alarmRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private AlphaVantageService alphaVantageService;

    public void process() throws Exception {
       List<Alarm> alarms = alarmRepository.findAll();
       for(Alarm alarm:alarms){
           if(sendAlarm(alarm)){
               SimpleMailMessage msg = new SimpleMailMessage();
               msg.setTo(alarm.getUserProduct().getInvestor().getEmail());

               msg.setSubject("Alarma "+alarm.getUserProduct().getProduct().getSymbol());
               msg.setText("Hola"+ alarm.getUserProduct().getInvestor().getName()
                       +" \n el producto "+alarm.getUserProduct().getProduct().getSymbol()+" ha superado el límite puesto en " + alarm.getAttribute().getName()
                       +"\n ");

               javaMailSender.send(msg);
           }


       }
    }
    private boolean sendAlarm(Alarm alarm){
        try {
            ProductInfo productInfo = alphaVantageService.getProductInfo(alarm.getUserProduct().getProduct().getSymbol());
            GlobalQuote globalQuote = productInfo.getGlobalQuote();
            if(globalQuote!= null){
                float maxVal = alarm.getMaxval();
                float minVal = alarm.getMinval();
                switch (alarm.getAttribute().getName()){
                    case CHANGE:
                      return   checkSendAlarm(minVal,maxVal,globalQuote.getChange());
                    case  OPEN:
                        return   checkSendAlarm(minVal,maxVal,globalQuote.getOpen());
                    case HIGH:
                        return   checkSendAlarm(minVal,maxVal,globalQuote.getHigh());
                    case LOW:
                        return   checkSendAlarm(minVal,maxVal,globalQuote.getLow());
                    case PRICE:
                        return   checkSendAlarm(minVal,maxVal,globalQuote.getPrice());
                    case VOLUME:
                        return   checkSendAlarm(minVal,maxVal,globalQuote.getVolume());
                    default:
                        return false;
                }
            }

            return false;
        }catch (Exception e){
            return false;
        }
    }

    private boolean checkSendAlarm(float minVal, float maxVal, float attribute){
        if(maxVal <= attribute|| attribute  <= minVal ){
            return true;
        }else{
            return false;
        }

    }
}
