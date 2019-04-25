package com.github.sejoung.service;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExecelServiceTest {

	@Autowired
	private ExecelService execelService;

	@Test
	public void saveSummaryKCP() throws IOException, InvalidFormatException {
		MockMultipartFile multipartFile = new MockMultipartFile("file", "test.xlsx",
				"text/plain", new FileInputStream("src/test/resources/test.xlsx"));
		execelService.saveSummaryKCP(multipartFile);
	}
}