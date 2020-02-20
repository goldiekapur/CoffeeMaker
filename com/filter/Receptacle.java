package com.filter;

import com.maincycle.DeliveryPipeControl;

public class Receptacle {
	private FilterHolder filterHolder = null;

	public void placeFilterHolder(FilterHolder filterHolder) {
		System.out.println("Placing FilterHolder into Receptacle");
		this.filterHolder = filterHolder;
	}

	public boolean isReceptacleEmpty() {
		return filterHolder != null;
	}

	public void sendCoffeetoSprayControl(DeliveryPipeControl deliveryPipeControl) {
		deliveryPipeControl.dripCoffeeintoPot();
	}
}
