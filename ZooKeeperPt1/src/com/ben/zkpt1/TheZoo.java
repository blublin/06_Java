package com.ben.zkpt1;

public class TheZoo {

	public static void main(String[] args) {
		System.out.println("Hi Mom, I did it!");
		
		Gorilla bigGuy = new Gorilla();
		
		bigGuy.throwSomething("rock");
		bigGuy.throwSomething("a branch");
		bigGuy.throwSomething("poo");
		
		bigGuy.eatBananas();
		bigGuy.eatBananas();
		
		bigGuy.climb();
		
		System.out.println("\nWhat a day at the zoo!!");
		

	}

}
