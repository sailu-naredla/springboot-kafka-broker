package com.kafkaservice.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaListenerService {

	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.topic.group.id}")
	public void listenerGroup(String message) {
	    log.info("Received Message in group TestTopicGroup: " + message);
	}
}
