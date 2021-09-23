package com.asiczen.device.msg.subscriber.serviceimpl;

import com.asiczen.device.msg.subscriber.dto.WMeterOriginalMessage;
import com.asiczen.device.msg.subscriber.dto.WaterMeterResponse;
import com.asiczen.device.msg.subscriber.model.WMMessage;
import com.asiczen.device.msg.subscriber.services.WMServices;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Base64;

@Component
@Slf4j
public class WMServicesImpl implements WMServices {

    public WMMessage generateWMMessage(WMeterOriginalMessage wmMessageDTO) {

        WMMessage wmMessage = new WMMessage();
        wmMessage.setDeviceName(wmMessageDTO.getDeviceName());
        wmMessage.setMessageCounter(wmMessageDTO.getFCnt());
        wmMessage.setDeviceEUI(wmMessageDTO.getDevEUI());
        wmMessage.setDeviceAddress(wmMessageDTO.getDevAddr());
        WaterMeterResponse response = decodeData(wmMessageDTO.getData());
        wmMessage.setBatteryPercentage(response.getBatteryPercentage());
        wmMessage.setMeterReading(response.getMeterReading());
        //Check what 0 or 1 means
        wmMessage.setCableStatus(response.getCableStatusValue() == 0 ? Boolean.TRUE : Boolean.FALSE);
        wmMessage.setTimeStamp(Instant.now());

        return wmMessage;
    }

    public WaterMeterResponse decodeData(String inputData) {
        byte[] decodedBytes = Base64.getDecoder().decode(inputData);
        String decodedString = bytesToHex(decodedBytes);
        String meterReading = decodedString.substring(0, Math.min(decodedString.length(), 8));
        String cableStatus = decodedString.substring(8, Math.min(decodedString.length(), 10));
        String batteryStatus = decodedString.substring(10, Math.min(decodedString.length(), 12));

        Integer meterReadingValue = Integer.valueOf(meterReading, 16);
        Integer cableStatusValue = Integer.valueOf(cableStatus, 16);
        Integer batteryStatusValue = Integer.valueOf(batteryStatus, 16);

        WaterMeterResponse waterMeterResponse = new WaterMeterResponse();

        waterMeterResponse.setMeterReading(meterReadingValue);
        waterMeterResponse.setCableStatusValue(cableStatusValue);
        waterMeterResponse.setBatteryPercentage(calculateBatteryPercentage(batteryStatusValue));


        return waterMeterResponse;
    }

    private int calculateBatteryPercentage(int batteryStatusValue) {
        return (int) ((batteryStatusValue / 255f) * 100);
    }


    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
