package com.finance.helper.batch;


        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.scheduling.annotation.Scheduled;
        import org.springframework.stereotype.Component;

        import java.util.Date;

@Component
public class BatchConfiguration {

    @Autowired
    private AlarmProcess alarmProcess;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void perform() throws Exception {
        //alarmProcess.process();
        System.out.println("Job Started at :" + new Date());
    }

}
