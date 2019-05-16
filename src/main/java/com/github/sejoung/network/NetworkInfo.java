package com.github.sejoung.network;

import static java.util.stream.Collectors.joining;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;


public class NetworkInfo {

	@Getter
	private String ips;

	public NetworkInfo() throws SocketException {
		ips = this.InterfaceInformation();
	}

	private String InterfaceInformation() throws SocketException {
		Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
		Set<String> ips = new HashSet<>();
		for (NetworkInterface netint : Collections.list(nets)) {
			ips.add(this.getInfomation(netint));
		}
		return ips.stream().filter(i -> i.length() > 1).collect(joining("|"));
	}

	private String getInfomation(NetworkInterface netint) {
		Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
		Set<String> info = new HashSet<>();
		for (InetAddress inetAddress : Collections.list(inetAddresses)) {
			info.add(this.getInetAddressInfomation(inetAddress));
		}
		return info.stream().filter(i -> i.length() > 1).collect(joining(","));
	}

	private String getInetAddressInfomation(InetAddress inetAddress) {
		String info = "";
		if (!inetAddress.isLoopbackAddress() && !inetAddress.getHostAddress().contains(":")
				&& inetAddress instanceof Inet4Address) {
			info = String.format("%s - %s", inetAddress.getHostAddress(),
					this.parserMacAddresses(inetAddress.getAddress()));
		}
		return info;
	}

	private String parserMacAddresses(byte[] mac) {
		String macAddress = "";
		for (byte b : mac) {
			macAddress += String.format("%02X", b);
		}
		return macAddress;
	}

}
