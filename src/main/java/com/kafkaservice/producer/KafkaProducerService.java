package com.kafkaservice.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaProducerService {
	
	@Value(value = "${kafka.topic.name}")
    private String topicName;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
        
	    ListenableFuture<SendResult<String, String>> future = 
	      kafkaTemplate.send(topicName, message);
		
	    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

	        @Override
	        public void onSuccess(SendResult<String, String> result) {
	            log.info("Sent message=[" + message + 
	              "] with offset=[" + result.getRecordMetadata().offset() + "]");
	        }
	        @Override
	        public void onFailure(Throwable ex) {
	            log.info("Unable to send message=[" 
	              + message + "] due to : " + ex.getMessage());
	        }
	    });
	}
}
