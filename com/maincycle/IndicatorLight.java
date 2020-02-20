package com.maincycle;

import com.OnOffControl;
import com.composite.BrewCycleComponent;

public class IndicatorLight implements OnOffControl, BrewCycleComponent {
	private boolean isOn = false;

	public IndicatorLight() {
		isOn = false;
	}

	public void On() {
		if (!isOn()) {
			this.isOn = true;
			System.out.println("Turning Indicator Light ON");
		}
	}

	public void Off() {
		if (isOn()) {
			this.isOn = false;
			System.out.println("Turning Indicator Light OFF");
		}
	}

	public boolean isOn() {
		return this.isOn;
	}

	@Override
	public void executeonBrewStart() {
		this.On();

	}

	@Override
	public void executeonBrewPause() {
		this.Off();
	}

	@Override
	public void executeonBrewFinish() {
		this.Off();
	}

}
