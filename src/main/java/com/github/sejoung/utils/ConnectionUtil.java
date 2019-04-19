package com.github.sejoung.utils;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ConnectionUtil {

	private final static String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final static String JDBC_URL = "jdbc:sqlserver://%s\\\\SQLEXPRESS:2433;database=TEST";
	private final static String USER_NAME = "test";
	private final static String PASSWORD = "test";

	public JdbcTemplate createJdbcTemplate(String ip) {
		return this.getJdbcTemplate(this.getDataSource(ip));
	}

	protected JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	protected HikariDataSource getDataSource(String ip) {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(JDBC_DRIVER);
		config.setJdbcUrl(String.format(JDBC_URL, ip));
		config.setUsername(USER_NAME);
		config.setPassword(PASSWORD);
		config.setMinimumIdle(1);
		config.setConnectionTimeout(3000);
		config.setIdleTimeout(10000);
		return new HikariDataSource(config);
	}

}
