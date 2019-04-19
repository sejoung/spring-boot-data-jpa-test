package com.github.sejoung.model;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
@Getter
public class DomainTestStatistics {

	private String title;
	private Long successCount;
	private LocalDateTime startDate;

	public DomainTestStatistics(String title, Long successCount, LocalDateTime startDate) {
		this.title = title;
		this.successCount = successCount;
		this.startDate = startDate;
	}
}
