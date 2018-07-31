package com.rld.systemConfigurations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Iterator;

import com.rld.Linuxexecution.ProcessListLinux;
import com.rld.windows.WindowsExecution;

/*
 * Class is used to get the system Configurations where SDK will be executed
 */
public class SystemConfiguration {

	public String SystemProperties() {

		// System.out.println(System.getProperty("path.separator"));
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("java.runtime.version"));

		// Retrieve the Application name where SDK will be executed
		if (System.getProperty("user.dir").length() > 0) {
			String Directory = System.getProperty("user.dir");
		}

		StringBuilder builder = new StringBuilder();

		/*
		 * Retrieve the Ip address and Mac address of system where SDK will be
		 * executed
		 */
		if (System.getProperty("os.name").equalsIgnoreCase("Linux")) {
			try {

				Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
				while (networks.hasMoreElements()) {
					NetworkInterface network = networks.nextElement();
					byte[] mac = network.getHardwareAddress();

					if (mac != null) {
						System.out.print("Current MAC address : ");

						builder = new StringBuilder();
						for (int i = 0; i < mac.length; i++) {
							builder.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
						}
						 System.out.println(builder.toString());
					}
				}
			} catch (SocketException e) {
				e.printStackTrace();
			} 
			return (builder.toString());
		} else
		// Retrive the ip and mac address for Windows OS TYPE
		{
			InetAddress ip;
			
			try {
				System.out.println("hello");
				ip = InetAddress.getLocalHost();
				
				NetworkInterface network = NetworkInterface.getByInetAddress(ip);
				byte[] mac = network.getHardwareAddress();

				builder = new StringBuilder();

				for (int i = 0; i < mac.length; i++) {
					builder.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
				}
				System.out.println(builder.toString());
			} catch (Exception err) {
				err.printStackTrace();
			}
		}
		return (builder.toString());
	}
	
	/**
	 * This method is used to get the public IP of the system.
	 * @return Public ip as String.
	 */
	public static String systemPublicIP() {
		String ipList = "";
		try {
			String publicIP = "";
			InetAddress ip;
			
			ip = InetAddress.getLocalHost();
			System.out.println("current IP address: " + ip.getHostAddress());
			
			URL ipAdress;
			ipAdress = new URL("http://myexternalip.com/raw");
	        BufferedReader in = new BufferedReader(new InputStreamReader(ipAdress.openStream()));
	        publicIP = in.readLine();
	        System.out.println("Public IP: " + publicIP);
	        
	        ipList = ip.getHostAddress() +", "+ publicIP;
	
	        return ipList;
		} catch (MalformedURLException e) {
            e.printStackTrace();
            return ipList;
        } catch (IOException e) {
            e.printStackTrace();
            return ipList;
        }
		
	}

	/**
	 * Accessing the process List from ProcessListlinux and WindowsExecution
	 * @return Process list in the string.
	 */
	public String ProcessList() {
		String Process_List = new String();
		if (System.getProperty("os.name").equalsIgnoreCase("Linux")) {
			ProcessListLinux process_list = new ProcessListLinux();
			Process_List = process_list.ProcessList();
		}

		else {

			WindowsExecution process_list = new WindowsExecution();
			Process_List = process_list.ProcessList();

		}
		return Process_List;
	}

}