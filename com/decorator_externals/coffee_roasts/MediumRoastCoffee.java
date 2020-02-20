package com.decorator_externals.coffee_roasts;

import com.decorator_externals.CoffeeBeverage;
import com.spray.MediumSpray;
import com.spray.Spray;

public class MediumRoastCoffee extends CoffeeBeverage {

	public MediumRoastCoffee() {
		super("Medium Roast Coffee");
	}

	public double cost() {
		return 1.10;
	}

	@Override
	public Spray getSpraySettings() {
		return new MediumSpray();
	}
}
