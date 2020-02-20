package com.filter;

public class Filter {
	private boolean hasGrounds;
	
	
	public Filter() {
		this.hasGrounds = false;
	}
	
	public void addGrounds() {
		this.hasGrounds = true;
		System.out.println("Added Coffee Grounds to Filter");
	}
	
	public boolean hasGrounds() {
		return this.hasGrounds;
	}
}
