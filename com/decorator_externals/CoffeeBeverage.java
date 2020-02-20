package com.decorator_externals;

import com.spray.MediumSpray;
import com.spray.Spray;

public abstract class CoffeeBeverage {

	private String desc = "Undefined Beverage";
	
	public CoffeeBeverage(String desc) {
		this.desc = desc;
	}
	
	public abstract double cost();
	
	public Spray getSpraySettings() {
		return new MediumSpray();
	}
	
	public String getDescription() {
		return desc;
	}
}
