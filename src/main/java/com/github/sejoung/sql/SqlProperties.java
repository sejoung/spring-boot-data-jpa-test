package com.github.sejoung.sql;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Slf4j
@ConfigurationProperties(prefix = "com.gihub.sejoung.sql")
public class SqlProperties {

	private String summaryPay;

}
