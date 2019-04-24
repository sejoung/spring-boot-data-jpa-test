package com.github.sejoung.controller;

import com.github.sejoung.service.SelectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SelectController {

	private final SelectService selectService;

	public SelectController(SelectService selectService) {
		this.selectService = selectService;
	}

	@GetMapping("/summaryPay")
	public void summaryPay(@RequestParam String ip) {
		selectService.saveSummaryPay(ip);
	}

}
