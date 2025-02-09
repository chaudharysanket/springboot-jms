package com.jms.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JMSConfig {

    @Value("${jms.url}")
    private String activeMqUrl;

    @Value("${jms.username}")
    private String activeMqUsername;

    @Value("${jms.password}")
    private String activeMqPassword;

    @Bean(name = "jms")
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        return new ActiveMQConnectionFactory(activeMqUsername, activeMqPassword, activeMqUrl);
    }

}
