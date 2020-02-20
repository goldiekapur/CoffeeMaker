package com.composite;

import java.util.LinkedList;
import java.util.List;

public class BrewCycleComposite implements BrewCycleComponent {
	private List<BrewCycleComponent> brewComponents;

	public BrewCycleComposite() {
		brewComponents = new LinkedList<>();
	}

	public List<BrewCycleComponent> getBrewComponents() {
		return this.brewComponents;
	}

	public void addComponent(BrewCycleComponent component) {
		brewComponents.add(component);
	}

	public boolean removeComponent(BrewCycleComponent component) {
		return brewComponents.remove(component);
	}

	// Updating Components
	public boolean updateComponent(BrewCycleComponent oldComp, BrewCycleComponent newComp) {
		int idx = brewComponents.indexOf(oldComp);

		if (idx == -1) {
			System.out.println("Failed to Update Component");
			return false;
		}

		removeComponent(oldComp);
		brewComponents.add(idx, newComp);
		return true;
	}

	@Override
	public void executeonBrewStart() {

		for (BrewCycleComponent comp : brewComponents) {
			comp.executeonBrewStart();
		}

	}

	@Override
	public void executeonBrewPause() {
		for (BrewCycleComponent comp : brewComponents) {
			comp.executeonBrewPause();
		}

	}

	@Override
	public void executeonBrewFinish() {
		for (BrewCycleComponent comp : brewComponents) {
			comp.executeonBrewFinish();
		}

	}

}
