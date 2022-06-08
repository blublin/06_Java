package com.ben.zkpt1;

public class Gorilla extends Mammal {
	public void throwSomething(String something) {
		System.out.println("This amazing gorilla threw a " + something + "!");
		setEnergy(displayEnergy() - 5);
	}
	public void eatBananas() {
		System.out.println("The gorilla CLEARLY loved the banana! Look at it's power rise!");
		setEnergy(displayEnergy() + 10);
	}
	public void climb() {
		System.out.println("Look at the gorilla go, climbing so high!");
		setEnergy(displayEnergy() - 10);
	}
}
