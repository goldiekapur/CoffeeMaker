package com.spray;

import com.decorator_externals.CoffeeBeverage;
import com.decorator_externals.coffee_roasts.MediumRoastCoffee;
import com.pot.Pot;

public class SprayControl {
	private Spray spray;
	
	public SprayControl() {
		spray = new MediumSpray();
	}
	
	public void changeSprayOption(Spray spray) {
		this.spray = spray;
	}
	
	public void changeSprayOptionBasedOffStrength(CoffeeBeverage coffeeBeverage) {
		this.spray = coffeeBeverage.getSpraySettings();
		this.spray.displayDetails();
	}
	
	public Spray getSpray() {
		return this.spray;
	}
	
	public void dripCoffeeintoPot(Pot pot) {
		// Have it set to "Drip" 1 cup at a time for simplicity
		pot.addCoffee(1, new MediumRoastCoffee());
		System.out.println(pot.getCoffeePotStatus());
	}
}
