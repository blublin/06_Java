package com.ben.zkpt2;

public class TheZoo {

	public static void main(String[] args) {
		System.out.println("Hi Mom, I did it!");
		
		Bat bigBat = new Bat();
		
		bigBat.attackTown();
		bigBat.attackTown();
		bigBat.attackTown();
		
		bigBat.eatHumans();
		bigBat.eatHumans();
		
		bigBat.fly();
		bigBat.fly();
		
		System.out.println(bigBat.displayEnergy()); 
		
		
		System.out.println("\nWhat a day at the zoo!!");
		

	}

}
