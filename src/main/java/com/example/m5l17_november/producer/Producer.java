package com.example.m5l17_november.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class Producer {

    public static void main(String[] args) {
        SpringApplication.run(Producer.class, args);
    }

//    @Bean
//    public NewTopic topic() {
//        return TopicBuilder
//                .name("demo-topic")
////                .partitions(10)
////                .replicas(1)
//                .build();
//    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
        return args -> {
            template.send("demo-topic", "test JavaRush" + System.currentTimeMillis());
        };
    }

}
