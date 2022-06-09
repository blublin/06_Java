package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	// MEMBER VARIABLES     	
    private ArrayList<String> patientNotes;	
	
    // TO DO: Constructor that takes an ID
    public Physician(Integer id) {
    	super(id);
    }
    // INSTANCE METHODS
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    // INTERFACE OVERRIDES
	@Override
	public boolean assignPin(int pin) {
		if (pin >= 1000 && pin <= 9999) {
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
		return false;
	}

	// GETTERS & SETTERS	
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}


	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
}

