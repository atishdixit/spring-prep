package com.ext.prep.perormance.vm.escaping_ref.obj.sol1;

public class Customer implements ReadOnlyCustomer {
	private String name;

	public Customer(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}

	public Customer(ReadOnlyCustomer customer) {
		this.name = customer.getName();
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return name;
	}
	
}
