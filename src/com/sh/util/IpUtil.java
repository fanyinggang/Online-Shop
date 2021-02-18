package com.sh.util;

import java.net.InetAddress;

public class IpUtil {

	public IpUtil() {
		// TODO Auto-generated constructor stub
	}
	public static String getLocalHostAddress() {
		String hostName;
		try {
			InetAddress addr = InetAddress.getLocalHost();
			hostName = addr.getHostAddress();
		} catch (Exception ex) {
			hostName = "";
		}
		return hostName;
	}
}
