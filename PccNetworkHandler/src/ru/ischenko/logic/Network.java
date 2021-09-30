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
	private String address;
	private boolean devicefull = false;
	
	
	public Network(String filial, String location, String address) {
		super();
		setFilial(filial);
		setLocation(location);
		setAddress(address);
	}
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isDevicefull() {
		return devicefull;
	}
	public void setDevicefull(boolean devicefull) {
		this.devicefull = devicefull;
	}
}
