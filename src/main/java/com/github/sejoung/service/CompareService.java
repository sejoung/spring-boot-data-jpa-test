package com.github.sejoung.service;

import com.github.sejoung.repositories.SummaryKCPRepository;
import org.springframework.stereotype.Service;

@Service
public class CompareService {

	private final SummaryKCPRepository repository;

	public CompareService(SummaryKCPRepository repository) {
		this.repository = repository;
	}



}
