package com.asiczen.device.msg.subscriber.serviceimpl;


import com.asiczen.device.msg.subscriber.dto.WMeterOriginalMessage;
import com.asiczen.device.msg.subscriber.model.WMMessage;
import com.asiczen.device.msg.subscriber.services.PublishToQueue;
import com.asiczen.device.msg.subscriber.services.WMServices;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PublishToQueueImpl implements PublishToQueue {

    @Autowired
    private KafkaTemplate<String, WMMessage> kafkaTemplate;

    @Autowired
    WMServices wmServices;

    private static final String TOPIC = "testWaterMeter";

    @Override
    public void publishMessages(WMeterOriginalMessage message) {
        WMMessage wmMessage = wmServices.generateWMMessage(message);
        kafkaTemplate.send(TOPIC, wmMessage);
        //messageSource.iotMessageSource().send(MessageBuilder.withPayload(wmMessage).build());
    }
}
