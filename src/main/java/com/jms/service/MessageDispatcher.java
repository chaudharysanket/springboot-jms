package com.jms.service;

import com.jms.util.Constants;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MessageDispatcher {

    @Autowired
    ProducerTemplate producerTemplate;

    public void sendMessage(Date time){
        producerTemplate.sendBody(Constants.DIRECT_SPRINGBOOTJMS_CAMEL_PATH, "test_"+time);
    }

}
