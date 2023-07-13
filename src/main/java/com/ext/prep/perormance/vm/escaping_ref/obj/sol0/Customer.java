package com.ext.prep.perormance.vm.escaping_ref.obj.sol0;

public class Customer {
	private String name;

	public String getName() {
		return name;
	}

	public Customer(Customer customer) {
		this.name = customer.getName();
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
}
