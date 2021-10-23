package com.graphometrica.rosatom_2021_backend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "active-mq")
public class ActiveMqProperties {
    private String brokerUrl = "";
    private String topic = "";
    private String queue = "";
    private RosatomProperties rosatom;
}