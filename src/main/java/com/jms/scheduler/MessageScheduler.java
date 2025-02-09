package com.jms.scheduler;

import com.jms.service.MessageDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class MessageScheduler {

    @Autowired
    MessageDispatcher messageDispatcher;

    @Scheduled(fixedRate = 2*60*1000)
    public void scheduleMessageSend(){
        messageDispatcher.sendMessage(Calendar.getInstance().getTime());
    }

}
