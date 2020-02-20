package com.boiler;

import com.OnOffControl;
import com.composite.BrewCycleComponent;
import com.maincycle.DeliveryPipeControl;

public class Boiler implements OnOffControl, BrewCycleComponent{
	// Contains
	// Boiler Heater
	// Water Sensor (is Empty basically)
	
	private final int MAX_NUM_CUPS = 12;
	private int currentNumCups;
	private boolean isBoilerOn;
	private boolean isWaterBoiling;
	
	public Boiler() {
		this.currentNumCups = 0;
		this.isBoilerOn = false;
	}	
	
	/**
	 * Adding water to the Boiler. If it exceeds the MAX_NUM_CUPS then the rest will spill out.
	 * Leaving the Boiler completely full.
	 * @param numofCups
	 */
	public void addWater(int numofCups) {
		
		int pouredAmountofWater = currentNumCups + numofCups;
		
		if(pouredAmountofWater > MAX_NUM_CUPS) {
			this.currentNumCups = MAX_NUM_CUPS;
			System.out.println(pouredAmountofWater - MAX_NUM_CUPS +" cups of water spills over the coffee maker.");
		}else {
			this.currentNumCups = pouredAmountofWater;
		}
		System.out.println("Boiler now Contains " + this.currentNumCups + " cups of water");
	}
	
	public void sendWatertoReceptacle(DeliveryPipeControl deliveryPipeControl) {
		this.currentNumCups -=1;
		System.out.println(getBoilerStatus());
		deliveryPipeControl.sendWatertoReceptacle();
	}
	
	
	public boolean isEmpty() {
		return currentNumCups == 0;
	}
	
	public boolean isBoiling() {
		return this.isWaterBoiling;
	}
	
	@Override
	public void On() {
		System.out.println("Boiler Heater Turned On");
		this.isBoilerOn = true;
		//TODO: Attempt to Start Boiling water
		this.isWaterBoiling = true;
		System.out.println("Water is now Boiling");
		//TODO: Once Water is Boiling, Water goes through sprayer into receptacle Coffee drips through filter into pot
	}

	@Override
	public void Off() {
		System.out.println("Boiler Heater Turned Off");
		this.isBoilerOn = false;
	}

	@Override
	public boolean isOn() {
		return isBoilerOn;
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
	
	private double getPercentageFull() {
		return Math.round(((double)currentNumCups/(double)MAX_NUM_CUPS) * 100.0);
	}
	
	public String getBoilerStatus() {
		return "Boiler contains " + currentNumCups + "/"+MAX_NUM_CUPS + " ("+getPercentageFull()+"%)";
	}
}
