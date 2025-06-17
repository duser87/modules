package org.attestation_final.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    public NewTopic employeeTopic(){
        return TopicBuilder.name("employee_srv").build();
    }
}
