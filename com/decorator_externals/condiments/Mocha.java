package com.decorator_externals.condiments;

import com.decorator_externals.CoffeeBeverage;
import com.decorator_externals.CondimentDecorator;

public class Mocha extends CondimentDecorator {
	public Mocha(CoffeeBeverage coffee) {
		super(coffee, "Mocha");
	}

	@Override
	public double cost() {
		return .90 + this.getCoffeeCup().cost();
	}

}
