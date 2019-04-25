package com.github.sejoung.service;

import com.github.sejoung.model.KCPMismatchPay;
import com.github.sejoung.repositories.SummaryKCPRepository;
import com.github.sejoung.repositories.SummaryPayRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CompareService {

	private final SummaryKCPRepository kcpRepository;

	private final SummaryPayRepository payRepository;

	private CompareService(SummaryKCPRepository kcpRepository, SummaryPayRepository payRepository) {
		this.kcpRepository = kcpRepository;
		this.payRepository = payRepository;
	}

	public List<KCPMismatchPay> getCompareList(){

		var kcpList = kcpRepository.findAllList();
		var payList = payRepository.findAllList();




		return null;

	}

}
