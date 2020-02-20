package com.maincycle;

import com.boiler.Boiler;
import com.composite.BrewCycleComponent;
import com.filter.Receptacle;
import com.pot.Pot;
import com.spray.SprayControl;

public class DeliveryPipeControl implements BrewCycleComponent{
	private Boiler boiler; 
	private Receptacle receptacle;
	private Pot pot;
	private SprayControl sprayControl;
	private int limitCycles;
	
	public DeliveryPipeControl(Boiler boiler, Receptacle receptacle, SprayControl sprayControl, Pot pot) {
		this.boiler = boiler;
		this.receptacle = receptacle;
		this.pot = pot;
		this.sprayControl = sprayControl;
		this.limitCycles = -1;
	}
	public DeliveryPipeControl(Boiler boiler, Receptacle receptacle, SprayControl sprayControl, Pot pot, int limitCycles) {
		this.boiler = boiler;
		this.receptacle = receptacle;
		this.pot = pot;
		this.sprayControl = sprayControl;
		this.limitCycles = limitCycles;
	}
	
	
	public void sendWatertoReceptacle() {
		receptacle.sendCoffeetoSprayControl(this);
	}
	public void dripCoffeeintoPot() {
		sprayControl.dripCoffeeintoPot(pot);
	}
	
	@Override
	public void executeonBrewStart() {
		//TODO Send water from boiler through receptacle into pot cup by cup
		
		//While Boiler is not empty keep sending water to receptacle
		System.out.println(boiler.getBoilerStatus());
		System.out.println(pot.getCoffeePotStatus());
		
		int count = 0;
		
		while(!boiler.isEmpty()) {
			
			// Jimmy Rig way to stop coffee from brewing after limitCycles cycles
			if(this.limitCycles > 0 && count >= this.limitCycles) {
				break;
			}
			
			boiler.sendWatertoReceptacle(this);
			
			count++;
		}
	}
	@Override
	public void executeonBrewPause() {
		System.out.println("DeliveryPipe has Stopped as Coffee Brew has paused");

	}
	@Override
	public void executeonBrewFinish() {
		System.out.println("DeliveryPipe is Empty as Coffee Brew is complete");
	}
}
