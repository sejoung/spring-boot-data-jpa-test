package com.github.sejoung.model;

import com.github.sejoung.constants.BreakerStatus;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class BreakerMessage {

	@NotEmpty
	private String parkSeq;

	@NotEmpty
	private String opCode;

	@NotEmpty
	private String deviceId;

	@NotNull
	private BreakerStatus event;

}
