package com.warmerplate;

import com.maincycle.IndicatorLight;

public class WarmerPlate {
	private PlateSensor plateSensor;
	private WarmerPlateHeatingElement heatingElement;
	
	public WarmerPlate() {
		this.plateSensor = new PlateSensor();
		this.heatingElement = new WarmerPlateHeatingElement();
	}
	public WarmerPlate(PlateSensor plateSensor) {
		this.plateSensor = plateSensor;
	}
		
	public void setPlateSensorState(PlateSensorState plateSensorState, IndicatorLight indicatorLight) {
		this.plateSensor.changeSensorState(plateSensorState);
		
		// Update Heating Element According to change
		this.plateSensor.heatingElementUpdate(heatingElement);
		
		this.plateSensor.indicatorLightUpdate(indicatorLight);
		// Display Change
		this.plateSensor.getSensorState().displayDetails();
	}
	
	public PlateSensor getPlateSensor() {
		return this.plateSensor;
	}
	
	public void turnOnPlateHeater() {
		this.heatingElement.On();
	}
	public void turnOffPlateHeater() {
		this.heatingElement.Off();
	}
	
	public boolean isPlateHeaderOn() {
		return heatingElement.isOn();
	}
	
}
