package com.github.sejoung.controller;

import com.github.sejoung.service.ExecelService;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

	private final ExecelService execelService;

	private FileUploadController(ExecelService execelService) {
		this.execelService = execelService;
	}

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file)
			throws IOException, InvalidFormatException {
		execelService.saveSummaryKCP(file);
		return "You successfully uploaded " + file.getOriginalFilename() + "!";
	}

}
