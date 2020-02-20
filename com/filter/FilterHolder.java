package com.filter;

public class FilterHolder {
	private Filter filter;
	
	public FilterHolder() {
		this.filter = null;
	}
	
	public void placeFilter(Filter filter) {
		System.out.println("Placeing Filter into FilterHolder");
		this.filter = filter;
	}
	
	public void addGroundstoFilter() {
		if(filter.hasGrounds()) {
			System.out.println("Filter already has grounds");
		}else {
			filter.addGrounds();
		}
	}
	
	public void removeFilter() {
		if(filter.hasGrounds()) {
			System.out.println("Removing Filter with Grounds from FilterHolder");
		}else {
			System.out.println("Removing Empty Filter from FilterHolder");
		}
		
		this.filter = null;
	}
	
	public boolean hasFilter() {
		return this.filter != null;
	}
	
}
