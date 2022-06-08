package com.ben.zkpt2;

public class Bat extends Mammal {
	public Bat() {
		super(300);
	}
	
	public void fly() {
		System.out.println("Oh my god, it's a bat! RUUUUUUUUUUUUN!");
		setEnergy(displayEnergy() - 50);
	}
	
	public void eatHumans() {
		System.out.println("Om nom nom nom");
		setEnergy(displayEnergy() +25);
	}
	
	public void attackTown() {
		System.out.println("In the distance, you can hear the sound a thousand voices screaming.");
		setEnergy(displayEnergy() - 100);
	}
}
