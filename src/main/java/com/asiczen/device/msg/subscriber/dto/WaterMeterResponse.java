package com.asiczen.device.msg.subscriber.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaterMeterResponse {
    private int meterReading;
    private int cableStatusValue;
    private int batteryPercentage;
}