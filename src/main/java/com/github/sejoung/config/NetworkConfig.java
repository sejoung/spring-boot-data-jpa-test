package com.github.sejoung.config;

import com.github.sejoung.network.NetworkInfo;
import java.net.SocketException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NetworkConfig {
	@Bean
	public NetworkInfo getNetworkInfo() throws SocketException {
		return new NetworkInfo();
	}

}
