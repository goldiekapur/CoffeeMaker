package com.decorator_externals;

public class CoffeeCup {

	private CoffeeBeverage beverage;
	
	public boolean recieveCoffee(CoffeeBeverage beverage) {
		if (this.containsCoffee()) {
			System.out.println("Coffee Cup Already Contains Coffee");
			return false;
		}
		this.beverage= beverage;

		return true;
	}
	
	public boolean containsCoffee() {
		return beverage != null;
	}
	
	public void setCoffeeBeverage(CoffeeBeverage beverage) {
		this.beverage = beverage;
	}
	public CoffeeBeverage getCoffeeBeverage() {
		return beverage;
	}
	
	public void summaryofCurrentCoffee() {
		if(!containsCoffee()) {
			System.out.println("Coffee Cup is Empty");
		}else {
			System.out.println("Contents: "+ this.beverage.getDescription() + ". Cost $"+ this.getCoffeeBeverage().cost());
		}
	}
}
