package com.warmerplate.platesensorstates;

import com.OnOffControl;
import com.warmerplate.PlateSensorState;

public class WarmerEmptyState implements PlateSensorState {

	@Override
	public void displayDetails() {
		System.out.println("Coffee Plate Sensor Changed to WarmerEmpty");
	}

	@Override
	public void heatingElementUpdate(OnOffControl heater) {
			heater.Off();
	}

	@Override
	public void indicatorLightUpdate(OnOffControl indicatorLight) {
			indicatorLight.Off();
	}

}
