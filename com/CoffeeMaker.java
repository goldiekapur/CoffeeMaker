package com;

import com.boiler.Boiler;
import com.composite.BrewCycleComposite;
import com.decorator_externals.CoffeeBeverage;
import com.decorator_externals.coffee_roasts.MediumRoastCoffee;
import com.filter.Filter;
import com.filter.FilterHolder;
import com.filter.Receptacle;
import com.maincycle.DeliveryPipeControl;
import com.maincycle.IndicatorLight;
import com.maincycle.ReliefValve;
import com.pot.Pot;
import com.spray.SprayControl;
import com.warmerplate.WarmerPlate;
import com.warmerplate.platesensorstates.WarmerEmptyState;

public class CoffeeMaker {
	private Boiler boiler;
	private FilterHolder filterHolder;
	private Receptacle receptacle;
	private ReliefValve reliefValve;
	private SprayControl sprayControl;
	private CoffeeBeverage coffeeBeverage;
	private WarmerPlate warmerPlate;
	private IndicatorLight indicatorLight;
	private Pot pot;
	private BrewCycleComposite brewCycleComposite;
	private DeliveryPipeControl deliveryPipeControl;

	public CoffeeMaker() {

		this.reliefValve = new ReliefValve();
		this.sprayControl = new SprayControl();
		this.warmerPlate = new WarmerPlate();
		this.filterHolder = new FilterHolder();
		this.receptacle = new Receptacle();
		this.coffeeBeverage = new MediumRoastCoffee();
		this.indicatorLight = new IndicatorLight();
		this.pot = null;
		this.boiler = new Boiler();
		this.deliveryPipeControl = new DeliveryPipeControl(boiler, receptacle, sprayControl, pot);

		this.brewCycleComposite = new BrewCycleComposite();

		// Fill up BrewCycle Composite
		brewCycleComposite.addComponent(reliefValve);
		brewCycleComposite.addComponent(boiler);
		brewCycleComposite.addComponent(indicatorLight);
		brewCycleComposite.addComponent(deliveryPipeControl);

	}
	
	public void placePot(Pot pot) {
		this.pot = pot;
		this.warmerPlate.setPlateSensorState(pot.getSensorState(), this.indicatorLight);

		DeliveryPipeControl newDPC = new DeliveryPipeControl(boiler, receptacle, sprayControl, pot);
		brewCycleComposite.updateComponent(deliveryPipeControl, newDPC);
		this.deliveryPipeControl = newDPC;

	}
	
	public void placePot(Pot pot, int stopCycle) {
		this.pot = pot;
		this.warmerPlate.setPlateSensorState(pot.getSensorState(), this.indicatorLight);

		DeliveryPipeControl newDPC = new DeliveryPipeControl(boiler, receptacle, sprayControl, pot, stopCycle);
		brewCycleComposite.updateComponent(deliveryPipeControl, newDPC);
		this.deliveryPipeControl = newDPC;

	}

	public Pot liftPot() {
		System.out.println("Lifting Pot From Coffee Brewer");
		this.warmerPlate.setPlateSensorState(new WarmerEmptyState(), this.indicatorLight);

		// Set Pot Back to Null, and return pot to requesting method
		Pot potForLifter = this.pot;
		this.pot = null;

		return potForLifter;
	}

	public void fillBoilerwithWater(int numofCups) {
		System.out.println("Adding Water to Boiler");
		this.boiler.addWater(numofCups);
	}

	public void placeFilterandGrindsintoHolder() {
		Filter filter = new Filter();
		filterHolder.placeFilter(filter);
		filter.addGrounds();
	}

	// TODO Dirty Code
	public void loadintoReceptacle() {
		this.receptacle.placeFilterHolder(this.filterHolder);
	}

	public void setStrength(CoffeeBeverage coffeeBeverage) {
		this.coffeeBeverage = coffeeBeverage;
		System.out.println("Set Strength to " + this.coffeeBeverage.getDescription());
		this.sprayControl.changeSprayOptionBasedOffStrength(coffeeBeverage);

	}

	public void startBrew() {
		System.out.println("Starting Brew Cycle");

		this.brewCycleComposite.executeonBrewStart();

		System.out.println("Finished Brew Cycle. Completing Finishing Tasks:");
		this.brewCycleComposite.executeonBrewFinish();
	}

}
