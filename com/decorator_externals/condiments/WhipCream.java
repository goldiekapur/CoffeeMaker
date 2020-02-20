package com.decorator_externals.condiments;

import com.decorator_externals.CoffeeBeverage;
import com.decorator_externals.CondimentDecorator;

public class WhipCream extends CondimentDecorator {
	public WhipCream(CoffeeBeverage coffee) {
		super(coffee, "Whip Cream");
	}

	@Override
	public double cost() {
		return 1.25 + this.getCoffeeCup().cost();
	}

}
