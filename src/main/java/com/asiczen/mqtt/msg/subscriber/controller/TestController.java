package com.asiczen.mqtt.msg.subscriber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asiczen.mqtt.msg.subscriber.model.OriginalMessage;
import com.asiczen.mqtt.msg.subscriber.source.IOTMessageSource;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class TestController {

	@Autowired
	IOTMessageSource iotMessageSource;

	@PostMapping("/message")
	public ResponseEntity<?> publishMessage(@RequestBody OriginalMessage message) {
		iotMessageSource.iotMessageSource().send(MessageBuilder.withPayload(message).build());
		return new ResponseEntity<>("message published successfully", HttpStatus.CREATED);
	}

}
