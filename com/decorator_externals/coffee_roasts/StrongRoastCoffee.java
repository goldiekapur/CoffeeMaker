package com.decorator_externals.coffee_roasts;

import com.decorator_externals.CoffeeBeverage;
import com.spray.FastSpray;
import com.spray.Spray;

public class StrongRoastCoffee extends CoffeeBeverage {

	public StrongRoastCoffee() {
		super("Strong Roast Coffee");
	}

	public double cost() {
		return 1.10;
	}

	@Override
	public Spray getSpraySettings() {
		return new FastSpray();
	}
}
