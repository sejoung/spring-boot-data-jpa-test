package com.github.sejoung.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectServiceTest {

	@Autowired
	private SelectService selectService;

	@Ignore("ip를 넣어서 테스트 해야됨")
	@Test
	public void saveSummaryPay() {

		selectService.saveSummaryPay("");
	}
}