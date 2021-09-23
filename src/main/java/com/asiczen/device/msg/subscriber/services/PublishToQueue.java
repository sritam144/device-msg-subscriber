package com.asiczen.device.msg.subscriber.services;

import com.asiczen.device.msg.subscriber.dto.WMeterOriginalMessage;

import org.springframework.stereotype.Service;

@Service
public interface PublishToQueue {
    public void publishMessages(WMeterOriginalMessage message);
}
