package com.graphometrica.rosatom_2021_backend.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import java.util.Arrays;

@Configuration
public class ActiveMQConfig {

    ActiveMqProperties activeMqProperties;

    ActiveMQConfig(ActiveMqProperties activeMqProperties) {
        this.activeMqProperties = activeMqProperties;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setPubSubDomain(true);
        return jmsTemplate;
    }

    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory  = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(activeMqProperties.getBrokerUrl());
        activeMQConnectionFactory.setTrustedPackages(Arrays.asList("com.graphometrica.rosatom_2021_backend"));
        return  activeMQConnectionFactory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsTopicListenerContainerFactory(){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setPubSubDomain(true);
        return factory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory(){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setPubSubDomain(false);
        return factory;
    }
}