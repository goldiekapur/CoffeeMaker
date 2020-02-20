package com.warmerplate;

import com.OnOffControl;
import com.warmerplate.platesensorstates.WarmerEmptyState;

public class PlateSensor{
	private PlateSensorState state;
	
	public PlateSensor() {
		this.state = new WarmerEmptyState();
	}
	public PlateSensor(PlateSensorState state) {
		this.state = state;
	}
	
	public void changeSensorState(PlateSensorState state) {
		this.state = state;
	}
	
	public void heatingElementUpdate(OnOffControl heatingElement) {
		state.heatingElementUpdate(heatingElement);
	}
	
	public void indicatorLightUpdate(OnOffControl indicatorLight) {
		state.indicatorLightUpdate(indicatorLight);
	}
	
	public PlateSensorState getSensorState() {
		return this.state;
	}
}
