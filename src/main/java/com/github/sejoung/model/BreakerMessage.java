package com.github.sejoung.model;

import com.github.sejoung.constants.BreakerStatus;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class BreakerMessage {

	@NotNull
	private BreakerStatus event;

}
