package com.kafkaservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafkaservice.dto.User;
import com.kafkaservice.producer.KafkaProducerService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private KafkaProducerService kafkaProducerService;
	
	@Override
	public boolean pushMessage(User user) {
		kafkaProducerService.sendMessage("Hello Topic");
		return true;
	}

}
