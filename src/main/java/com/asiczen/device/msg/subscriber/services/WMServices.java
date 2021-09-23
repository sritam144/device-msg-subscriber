package com.asiczen.device.msg.subscriber.services;


import com.asiczen.device.msg.subscriber.dto.WMeterOriginalMessage;
import com.asiczen.device.msg.subscriber.model.WMMessage;

import org.springframework.stereotype.Service;

@Service
public interface WMServices {

    public WMMessage generateWMMessage(WMeterOriginalMessage wmMessageDTO);

}
