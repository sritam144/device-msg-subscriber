package com.asiczen.device.msg.subscriber.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class WMeterOriginalMessage {

	@JsonProperty("deviceName")
	private String deviceName;

	@JsonProperty("devEUI")
	private String devEUI;

	@JsonProperty("data")
	private String data;

	@JsonProperty("fCnt")
	private long fCnt;

	@JsonProperty("devAddr")
	private String devAddr;

	@JsonProperty("time")
	private Date time;


}
