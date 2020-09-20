package com.asiczen.mqtt.msg.subscriber.publisher;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.asiczen.mqtt.msg.subscriber.source.IOTMessageSource;

@EnableBinding(IOTMessageSource.class)
public class IOTMessagePublisher {

}
