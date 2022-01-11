package com.example.springnative.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SomeKafkaListener {

    @KafkaListener(
            topics = "${KAFKA_TOPIC_NAME}",
            groupId = "${KAFKA_GROUP_ID}"
    )
    public void listen(ConsumerRecord<String, String> record) {
        try {
            log.info(record.value());
        } catch (Exception e) {
            log.error("Unable to process message [reason: {}]", e.getMessage(), e);
        }
    }
}
