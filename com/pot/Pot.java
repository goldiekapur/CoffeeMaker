package com.pot;

import com.decorator_externals.CoffeeBeverage;
import com.decorator_externals.CoffeeCup;
import com.warmerplate.PlateSensorState;
import com.warmerplate.platesensorstates.PotEmptyState;
import com.warmerplate.platesensorstates.PotNotEmptyState;

public class Pot {
	private PlateSensorState state;
	private int MAX_NUMBER_CUPS = 12;
	private CoffeeBeverage potContents;
	private int currentAmountCups;
	
	public Pot() {
		this.currentAmountCups = 0;
		state = new PotEmptyState();
	}
	
	public void addCoffee(int amountAddedCups, CoffeeBeverage addition) {
		this.potContents = addition;
		
		if(this.currentAmountCups + amountAddedCups > MAX_NUMBER_CUPS) {
			System.out.println("Coffee Pot is now full. Extra Cups spilled over pot.");
			this.currentAmountCups = MAX_NUMBER_CUPS;
		}else {
			this.currentAmountCups += amountAddedCups;
		}
		
		if(this.currentAmountCups > 0) {
			state = new PotNotEmptyState();
		}
	
	}
	
	public boolean pourCoffeeintoCup(CoffeeCup cup) {
		if(currentAmountCups < 1) {
			System.out.println("Pot is empty, did not fill cup with coffee.");
			return false;
		}
		
		if(cup.recieveCoffee(potContents)) {
			this.currentAmountCups -= 1;
			System.out.println("Poured 1 cup of coffee into a cup");
			return true;
		}else {
			// Coffee Cup already Contains Coffee
			return false;
		}
	}
	public PlateSensorState getSensorState() {
		return this.state;
	}
	
	public int getCurrentAmountCups() {
		return this.currentAmountCups;
	}
	
	private double getPercentageFull() {
		return Math.round(((double)(currentAmountCups/(double)MAX_NUMBER_CUPS) * 100.0));
	}
	
	public String getCoffeePotStatus() {
		return "Coffee Pot contains " + currentAmountCups + "/"+MAX_NUMBER_CUPS + " ("+getPercentageFull()+"%)";
	}
	
	//public abstract void handlePotPlacedinCoffeeMachine(CoffeeMaker cm);
}
