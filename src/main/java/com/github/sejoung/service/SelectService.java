package com.github.sejoung.service;

import com.github.sejoung.domain.SummaryPay;
import com.github.sejoung.domain.SummaryPayKey;
import com.github.sejoung.repositories.SummaryPayRepository;
import com.github.sejoung.sql.SqlProperties;
import com.github.sejoung.utils.ConnectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SelectService {

	private final ConnectionUtil connectionUtil;

	private final SummaryPayRepository repository;

	private final SqlProperties properties;

	private SelectService(ConnectionUtil connectionUtil, SummaryPayRepository repository,
			SqlProperties properties) {
		this.connectionUtil = connectionUtil;
		this.repository = repository;
		this.properties = properties;
	}

	public void saveSummaryPay(String ip) {
		var jt = connectionUtil.createJdbcTemplate(ip);
		var data = jt.queryForList(properties.getSummaryPay());
		data.forEach((map) -> {
			var payKey = SummaryPayKey.builder().day(map.get("day").toString())
					.payType(map.get("payType").toString()).productType(map.get("productType").toString())
					.build();
			var summaryPay = SummaryPay.builder().key(payKey).amount((Integer) map.get("amount"))
					.cnt((Integer) map.get("cnt")).build();
			log.debug(summaryPay.toString());
			repository.save(summaryPay);
		});


	}

}
