package com.asiczen.device.msg.subscriber.controller;

import com.asiczen.device.msg.subscriber.dto.WMeterOriginalMessage;
import com.asiczen.device.msg.subscriber.services.PublishToQueue;
import com.asiczen.device.msg.subscriber.services.WMServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/device")
@Slf4j
public class WMeterController {

	@Autowired
	PublishToQueue publishToQueue;

	@PostMapping("/watermeter")
	public ResponseEntity<?> publishMessage(@RequestBody WMeterOriginalMessage message) {
		publishToQueue.publishMessages(message);
		return new ResponseEntity<>("message published successfully", HttpStatus.CREATED);
	}

}
