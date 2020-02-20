package com.maincycle;

import com.OpenCloseControl;
import com.composite.BrewCycleComponent;

public class ReliefValve implements OpenCloseControl, BrewCycleComponent{
	private boolean isOpen;
	
	public ReliefValve() {
		this.isOpen = true;
	}
	
	
	public boolean isOpen() {
		return this.isOpen;
	}

	@Override
	public void Open() {
		System.out.println("Opened Relief Valve");
		this.isOpen = true;
	}

	@Override
	public void Close() {
		System.out.println("Closed Relief Valve");
		this.isOpen = false;
		
	}


	@Override
	public void executeonBrewStart() {
		this.Close();
	}


	@Override
	public void executeonBrewPause() {
		this.Open();
	}


	@Override
	public void executeonBrewFinish() {
		this.Open();
	}

}
