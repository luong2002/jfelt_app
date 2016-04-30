package entities;

import java.io.Serializable;

public class Driver extends Entity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String license;
	private String carDescription;
	
	
	public Driver(String name, String id, String license, String carDecription) {
		super(id, name);
		this.license = license;
		this.carDescription = carDecription;
	}
	

	public String getLicense() {
		return license;
	}
	
	public String getCarDescription() {
		return carDescription;
	}
	
}
