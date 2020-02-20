package com.decorator_externals.condiments;

import com.decorator_externals.CoffeeBeverage;
import com.decorator_externals.CondimentDecorator;

public class Cinnamon extends CondimentDecorator {
	public Cinnamon(CoffeeBeverage coffee) {
		super(coffee, "Cinnamon");
	}

	@Override
	public double cost() {
		return .50 + this.getCoffeeCup().cost();
	}

}
