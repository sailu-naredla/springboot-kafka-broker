package com.kafkaservice.service;

import com.kafkaservice.dto.User;

public interface UserService {

	public boolean pushMessage(User user);
}
