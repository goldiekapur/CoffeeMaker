package com.warmerplate.platesensorstates;

import com.OnOffControl;
import com.warmerplate.PlateSensorState;

public class PotNotEmptyState implements PlateSensorState{

	@Override
	public void displayDetails() {
		System.out.println("Coffee Plate Sensor Changed to PotNotEmptyState");
	}

	@Override
	public void heatingElementUpdate(OnOffControl heater) {
			heater.On();
	}

	@Override
	public void indicatorLightUpdate(OnOffControl indicatorLight) {
			indicatorLight.On();
	}

}
