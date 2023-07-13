package com.ext.prep.perormance.vm.escaping_ref.sol0;

public class Customer {
	private String name;

	public String getName() {
		return name;
	}

	public Customer(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
}
