package com.github.sejoung.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
@Getter
public class KCPMismatchPay {

	private String day;
	private Integer kcpCnt;
	private Integer kcpAmount;
	private Integer payCnt;
	private Integer payAmount;

	@Builder
	private KCPMismatchPay(String day, Integer kcpCnt, Integer kcpAmount, Integer payCnt,
			Integer payAmount) {
		this.day = day;
		this.kcpCnt = kcpCnt;
		this.kcpAmount = kcpAmount;
		this.payCnt = payCnt;
		this.payAmount = payAmount;
	}
}
