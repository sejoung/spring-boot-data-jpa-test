package com.github.sejoung.controller;

import com.github.sejoung.model.BreakerMessage;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BreakerAPIController {

	private static final Logger log = LoggerFactory.getLogger(BreakerAPIController.class);

	@RequestMapping(value = "/parkingBreaker", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void parkingBreaker(@RequestBody @Valid BreakerMessage message) {
		log.debug("parkingBreaker = {}", message);
	}

}
