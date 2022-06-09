package com.caresoft.clinicapp;

import java.util.Date;
import java.util.ArrayList;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {

    // MEMBER VARIABLES 
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
    // CONSTRUCTOR
    public AdminUser(Integer id, String role) {
    	super(id);
    	this.role = role;
    }
    
    // INSTANCE METHODS
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    // INTERFACE OVERRIDES
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		if (securityIncidents.size() != 0) {
			return securityIncidents;
		}
		return null;
	}

	@Override
	public boolean assignPin(int pin) {
		if (pin >= 100_000) {
			setPin(pin);
			return true;
		}
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (pin != 0 && pin == confirmedAuthID) {
			return true;
		}
		authIncident();
		return false;
	}
	
	// GETTERS & SETTERS
	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

}
