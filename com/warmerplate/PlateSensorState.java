package com.warmerplate;

import com.OnOffControl;

public interface PlateSensorState {
	public void displayDetails();
	public void heatingElementUpdate(OnOffControl heater);
	public void indicatorLightUpdate(OnOffControl indicatorLight);
}
