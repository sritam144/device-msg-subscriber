package com.asiczen.device.msg.subscriber.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WMMessage {

    private String deviceName;
    private String deviceEUI;
    private long messageCounter;
    private String deviceAddress;
    private Instant timeStamp;
    private int meterReading;
    private boolean cableStatus;
    private float batteryPercentage;

}
