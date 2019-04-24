package com.github.sejoung.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
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

}
