package com.jms.config;

import com.jms.util.Constants;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig extends RouteBuilder {

    @Value("${jms.queue}")
    private String jmsQueue;

    @Override
    public void configure() {
        //creating a route from application to jms queue
        from(Constants.DIRECT_SPRINGBOOTJMS_CAMEL_PATH)
                .log("Sending jms message ${body}")
                .to(Constants.JMS_QUEUE +jmsQueue);

        //creating a route from queue to our application
        from(Constants.JMS_QUEUE +jmsQueue)
                .log("Received message from queue "+jmsQueue)
                .process(exchange ->{
                    String message = exchange.getIn().getBody(String.class);
                    System.out.println("Message is: "+message);
                });
    }
}
