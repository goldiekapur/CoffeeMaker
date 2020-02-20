package com.decorator_externals;

public abstract class CondimentDecorator extends CoffeeBeverage {

	private CoffeeBeverage coffee;
	private String condiment;

	public CondimentDecorator(CoffeeBeverage coffee, String condiment) {
		super(condiment);
		this.coffee = coffee;
		this.condiment = condiment;
	}

	protected CoffeeBeverage getCoffeeCup() {
		return coffee;
	}

	public String getDescription() {
		return getCoffeeCup().getDescription() + ", " + condiment;
	}
}