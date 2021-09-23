package com.asiczen.device.msg.subscriber;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class MqttMsgSubscriberApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void postMessageClientError() throws Exception {

		String newMessage = "{\"IMEI\":\"867584035018865\",\"GPS\":1,\"Lat\":20.363877,\"Lng\":85.836325,\"IsKeyOn\":false,\"Heading\":121,\"Timestamp\":\"2020-09-18T11:42:20.000+00:00\",\"Unplugged\":0,\"Fuel\":0,\"Speed\":0}";

		mockMvc.perform(MockMvcRequestBuilders.post("/dummyMessage").contentType(MediaType.APPLICATION_JSON)
				.content(newMessage).accept(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError())
				.andReturn();

	}

	@Test
	public void postMessage() throws Exception {

		String newMessage = "{\"IMEI\":\"867584035018865\",\"GPS\":1,\"Lat\":20.363877,\"Lng\":85.836325,\"IsKeyOn\":false,\"Heading\":121,\"Timestamp\":\"2020-09-18T11:42:20.000+00:00\",\"Unplugged\":0,\"Fuel\":0,\"Speed\":0}";

		mockMvc.perform(MockMvcRequestBuilders.post("/api/message").contentType(MediaType.APPLICATION_JSON)
				.content(newMessage).accept(MediaType.APPLICATION_JSON)).andExpect(status().is(201)).andReturn();

	}
}
