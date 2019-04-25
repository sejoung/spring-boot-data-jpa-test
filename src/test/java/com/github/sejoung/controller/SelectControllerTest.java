package com.github.sejoung.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SelectControllerTest {

	@Autowired
	private MockMvc mvc;

	@Ignore("ip를 넣어서 테스트 해야됨")
	@Test
	public void summaryPay() throws Exception {

		this.mvc.perform(get("/summaryPay").param("ip",""))
				.andDo(print())
				.andExpect(status().isOk());
	}
}