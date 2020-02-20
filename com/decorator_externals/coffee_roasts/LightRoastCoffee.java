package com.decorator_externals.coffee_roasts;

import com.decorator_externals.CoffeeBeverage;
import com.spray.SlowSpray;
import com.spray.Spray;

public class LightRoastCoffee extends CoffeeBeverage {

	public LightRoastCoffee() {
		super("Light Roast Coffee");
	}

	public double cost() {
		return 1.10;
	}

	@Override
	public Spray getSpraySettings() {
		return new SlowSpray();
	}
}