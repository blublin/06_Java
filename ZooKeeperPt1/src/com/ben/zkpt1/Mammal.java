package com.ben.zkpt1;

public class Mammal {
	private int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
//	|----- GET/SET -----|
	public void setEnergy(int energy) {
		energyLevel = energy;
	}
	public int displayEnergy() {
		return energyLevel;
	}

}
