package com.kafkaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaservice.dto.User;
import com.kafkaservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/push")
	public boolean pushNotification(@RequestBody User user) {
		log.info("Entering userService");
		boolean response = userService.pushMessage(user);
		log.info("Exiting userService");
		return response;
	}

}
