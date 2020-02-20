package com;

import com.decorator_externals.CoffeeCup;
import com.decorator_externals.coffee_roasts.LightRoastCoffee;
import com.decorator_externals.condiments.Cinnamon;
import com.decorator_externals.condiments.Mocha;
import com.decorator_externals.condiments.WhipCream;
import com.pot.Pot;

public class CoffeeMakerTest {
	public static void main(String[] args) {
		
		CoffeeMaker coffeemaker = new CoffeeMaker();
		Pot pot = new Pot();
		
		System.out.println();
		System.out.println("A Case");
		
		coffeemaker = new CoffeeMaker();
		pot = new Pot();
		
		// Put empty pot on warmer
		System.out.println("Placing Empty Pot in CoffeeMaker");
		coffeemaker.placePot(pot, 9);
		// Fill Boiler with water
		coffeemaker.fillBoilerwithWater(12);
		// Put filter and coffee grounds into filter holder
		coffeemaker.placeFilterandGrindsintoHolder();
		// Load it into the receptacle
		coffeemaker.loadintoReceptacle();
		// Select the coffee strength (strong, medium, light) medium is default
		coffeemaker.setStrength(new LightRoastCoffee());
		// Press Brew Button (Start Brewing)
		coffeemaker.startBrew();
		
		pot = coffeemaker.liftPot();
		// Stop Brewing 1/4th the way through
		// This is handled When passing in 3 into "coffeemaker.placePot(pot, 3);" As, I have it set as kind of a custom stopping mechanism
		
		
		System.out.println();
		System.out.println("Making Coffee For herself");
		CoffeeCup cupofMorningJoe = new CoffeeCup();
		
		System.out.println(pot.getCoffeePotStatus());
		pot.pourCoffeeintoCup(cupofMorningJoe);
		System.out.println(pot.getCoffeePotStatus());
		cupofMorningJoe.summaryofCurrentCoffee();
		
		// Adding WhipCream to my cup of JOE
		cupofMorningJoe.setCoffeeBeverage(new WhipCream(cupofMorningJoe.getCoffeeBeverage()));
		System.out.println("Final Product:");
		cupofMorningJoe.summaryofCurrentCoffee();
		System.out.println();
		
		
		// Return Brewing till complete
		System.out.println("Placing Pot Back into Coffee Maker");
		coffeemaker.placePot(pot);
		coffeemaker.startBrew();
		
		
		
		
		System.out.println();
		System.out.println("B Case ");
		
		coffeemaker = new CoffeeMaker();
		pot = new Pot();
		
		// Put empty pot on warmer
		System.out.println("Placing Empty Pot in CoffeeMaker");
		coffeemaker.placePot(pot, 3);
		// Fill Boiler with water
		coffeemaker.fillBoilerwithWater(12);
		// Put filter and coffee grounds into filter holder
		coffeemaker.placeFilterandGrindsintoHolder();
		// Load it into the receptacle
		coffeemaker.loadintoReceptacle();
		// Select the coffee strength (strong, medium, light) medium is default
		coffeemaker.setStrength(new LightRoastCoffee());
		// Press Brew Button (Start Brewing)
		coffeemaker.startBrew();
		
		pot = coffeemaker.liftPot();
		// Stop Brewing 1/4th the way through
		// This is handled When passing in 3 into "coffeemaker.placePot(pot, 3);" As, I have it set as kind of a custom stopping mechanism
		
		
		System.out.println();
		System.out.println("Making Coffee For hereself");
		CoffeeCup cupofJoeforHer = new CoffeeCup();
		
		System.out.println(pot.getCoffeePotStatus());
		pot.pourCoffeeintoCup(cupofJoeforHer);
		System.out.println(pot.getCoffeePotStatus());
		cupofJoeforHer.summaryofCurrentCoffee();
		
		// Adding WhipCream to my cup of JOE
		cupofJoeforHer.setCoffeeBeverage(new Cinnamon(cupofJoeforHer.getCoffeeBeverage()));
		System.out.println("Final Product:");
		cupofJoeforHer.summaryofCurrentCoffee();
		System.out.println();
		
		
		// Return Brewing till complete
		System.out.println("Placing Pot Back into Coffee Maker");
		coffeemaker.placePot(pot);
		coffeemaker.startBrew();
		
		System.out.println();
		System.out.println("Making Coffee for her friend");
		CoffeeCup cupofJoeforHerFriend = new CoffeeCup();
		
		System.out.println(pot.getCoffeePotStatus());
		pot.pourCoffeeintoCup(cupofJoeforHerFriend);
		System.out.println(pot.getCoffeePotStatus());
		cupofJoeforHerFriend.summaryofCurrentCoffee();
		
		// Adding Mocha to my cup of JOE
		cupofJoeforHerFriend.setCoffeeBeverage(new Mocha(cupofJoeforHerFriend.getCoffeeBeverage()));
		System.out.println("Final Product:");
		cupofJoeforHerFriend.summaryofCurrentCoffee();
		


		
		
//		// CODE FOR USECASES, UnComment If you want to See. Basically same as A and B
//		System.out.println("---- Use Case 1 ----");
//		
//		// Put empty pot on warmer
//		coffeemaker.placePot(pot);
//		// Fill Boiler with water
//		coffeemaker.fillBoilerwithWater(12);
//		// Put filter and coffee grounds into filter holder
//		coffeemaker.placeFilterandGrindsintoHolder();
//		// Load it into the receptacle
//		coffeemaker.loadintoReceptacle();
//		// Select the coffee strength (strong, medium, light) medium is default
//		coffeemaker.setStrength(new LightRoastCoffee());
//		// Press Brew Button (Start Brewing)
//		coffeemaker.startBrew();
//	
//		System.out.println();
//		System.out.println("---- Use Case 2 ----");
//		
//		pot = coffeemaker.liftPot();
//		
//		CoffeeCup cupofJoe = new CoffeeCup();
//		
//		System.out.println(pot.getCoffeePotStatus());
//		pot.pourCoffeeintoCup(cupofJoe);
//		System.out.println(pot.getCoffeePotStatus());
//		cupofJoe.summaryofCurrentCoffee();
//		
//		// Adding Mocha to my cup of JOE
//		cupofJoe.setCoffeeBeverage(new Mocha(cupofJoe.getCoffeeBeverage()));
//		cupofJoe.summaryofCurrentCoffee();
//		
//		// Adding WhipCream to my cup of JOE
//		cupofJoe.setCoffeeBeverage(new Cinnamon(cupofJoe.getCoffeeBeverage()));
//		cupofJoe.summaryofCurrentCoffee();
		
//		System.out.println();
//		System.out.println("---- Use Case 3 ----");
//		coffeemaker = new CoffeeMaker();
//		pot = new Pot();
//		
//		// Put empty pot on warmer
//		System.out.println("Placing Empty Pot in CoffeeMaker");
//		coffeemaker.placePot(pot, 4);
//		// Fill Boiler with water
//		coffeemaker.fillBoilerwithWater(12);
//		// Put filter and coffee grounds into filter holder
//		coffeemaker.placeFilterandGrindsintoHolder();
//		// Load it into the receptacle
//		coffeemaker.loadintoReceptacle();
//		// Select the coffee strength (strong, medium, light) medium is default
//		coffeemaker.setStrength(new LightRoastCoffee());
//		// Press Brew Button (Start Brewing)
//		coffeemaker.startBrew();
//		
//		pot = coffeemaker.liftPot();
//		
//		System.out.println();
//		// Return Brewing till complete
//		System.out.println("Placing Pot Back into Coffee Maker");
//		coffeemaker.placePot(pot);
//		coffeemaker.startBrew();
	
		
	}
}
