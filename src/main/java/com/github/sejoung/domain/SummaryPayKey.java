package com.github.sejoung.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
@ToString
@NoArgsConstructor
public class SummaryPayKey implements Serializable {

	@EqualsAndHashCode.Include
	@Column
	private String day;

	@EqualsAndHashCode.Include
	@Column
	private String payType;

	@EqualsAndHashCode.Include
	@Column
	private String productType;

	@Builder
	private SummaryPayKey(String day, String payType, String productType) {
		this.day = day;
		this.payType = payType;
		this.productType = productType;
	}
}
