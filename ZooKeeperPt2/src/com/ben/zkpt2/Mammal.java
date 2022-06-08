package com.ben.zkpt2;

public class Mammal {
	private int energyLevel;
	
	public Mammal(int energy) {
		this.energyLevel = energy;
	}
	
//	|----- GET/SET -----|
	public void setEnergy(int energy) {
		energyLevel = energy;
	}
	public int displayEnergy() {
		return energyLevel;
	}

}
