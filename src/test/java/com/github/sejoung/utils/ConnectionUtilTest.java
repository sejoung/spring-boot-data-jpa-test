package com.github.sejoung.utils;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConnectionUtilTest {


	@Autowired
	private ConnectionUtil connectionUtil;

	@Ignore("ip를 넣어서 테스트 해야됨")
	@Test
	public void createJdbcTemplate() {
		JdbcTemplate jt = connectionUtil.createJdbcTemplate("");
	}
}