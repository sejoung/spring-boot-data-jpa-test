package com.github.sejoung.utils;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Setter
@Component
@Slf4j
@ConfigurationProperties(prefix = "com.gihub.sejoung.connection")
public class ConnectionUtil {

	private String driverClassName;
	private String url;
	private String username;
	private String password;


	public JdbcTemplate createJdbcTemplate(String ip) {
		return this.getJdbcTemplate(this.getDataSource(ip));
	}

	protected JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	protected HikariDataSource getDataSource(String ip) {
		log.debug(" driverClassName={}, url={}, username={}, password={}", driverClassName, url,
				username, password);

		HikariConfig config = new HikariConfig();
		config.setDriverClassName(this.driverClassName);
		config.setJdbcUrl(String.format(this.url, ip));
		config.setUsername(this.username);
		config.setPassword(this.password);
		config.setMinimumIdle(1);
		config.setConnectionTimeout(3000);
		config.setIdleTimeout(10000);
		config.setMaxLifetime(4000);
		config.setReadOnly(true);
		return new HikariDataSource(config);
	}

}
