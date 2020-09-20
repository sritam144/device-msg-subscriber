package com.asiczen.mqtt.msg.subscriber.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface IOTMessageSource {

	@Output("iotMessageChannel")
	MessageChannel iotMessageSource();
}
