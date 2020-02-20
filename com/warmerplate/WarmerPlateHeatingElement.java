package com.warmerplate;

import com.OnOffControl;

public class WarmerPlateHeatingElement implements OnOffControl {
	private boolean isOn = false;

	@Override
	public void On() {
		if (!isOn()) {
			System.out.println("Warmer Plate's Heating Element has turned on");
			this.isOn = true;
		}
	}

	@Override
	public void Off() {
		if (isOn()) {
			System.out.println("Warmer Plate's Heating Element has turned off");
			this.isOn = false;
		}

	}

	public boolean isOn() {
		return this.isOn;
	}

}
