package com.github.sejoung.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.github.sejoung.constants.BreakerStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BreakerAPIControllerTest {


	private final String breakerAPIControllerParkingBreakerUrl = "/parkingBreaker";

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void parkingBreakerIsUnsupportedMediaType() throws Exception {
		this.mockMvc.perform(post(breakerAPIControllerParkingBreakerUrl)
				.content(
						"{\"parkSeq\":\"512\",\"opCode\":\"1\",\"deviceId\":\"M01\",\"event\":\"RELAY_IN_OPEN\"}"))
				.andDo(print())
				.andExpect(status().isUnsupportedMediaType());
	}


	@Test
	public void parkingBreakerIsOk() throws Exception {
		this.mockMvc.perform(post(breakerAPIControllerParkingBreakerUrl)
				.content(
						"{\"parkSeq\":\"512\",\"opCode\":\"1\",\"deviceId\":\"M01\",\"event\":\""
								+ BreakerStatus.RELAY_IN_CLOSE.toString() + "\"}")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void parkingBreakerNoParkSeq() throws Exception {
		this.mockMvc.perform(post(breakerAPIControllerParkingBreakerUrl)
				.content(
						"{\"parkSeq\":\"\",\"opCode\":\"1\",\"deviceId\":\"M01\",\"event\":\""
								+ BreakerStatus.RELAY_IN_CLOSE.toString() + "\"}")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}

	@Test
	public void parkingBreakerNoEvent() throws Exception {
		this.mockMvc.perform(post(breakerAPIControllerParkingBreakerUrl)
				.content(
						"{\"parkSeq\":\"512\",\"opCode\":\"1\",\"deviceId\":\"M01\",\"event\":\"\"}")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}

	@Test
	public void parkingBreakerBadEvent() throws Exception {
		this.mockMvc.perform(post(breakerAPIControllerParkingBreakerUrl)
				.content(
						"{\"parkSeq\":\"512\",\"opCode\":\"1\",\"deviceId\":\"M01\",\"event\":\"12313\"}")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}
}