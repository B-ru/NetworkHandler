package ru.ischenko.logic;
/**
 * Network class responsible for containing most basic information about single network
 * <br>Class attributes:
 * <br>filial
 * <br>location
 * <br>network address
 * <br>devicefull 
 */
public class Network {

	private String filial;
	private String location;
	private String network;
	private boolean devicefull;
	
	public String getFilial() {
		return filial;
	}
	public void setFilial(String filial) {
		this.filial = filial;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public boolean isDevicefull() {
		return devicefull;
	}
	public void setDevicefull(boolean devicefull) {
		this.devicefull = devicefull;
	}
}
