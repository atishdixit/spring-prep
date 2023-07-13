package com.ext.prep.perormance.vm.escaping_ref.sol1;

import java.util.HashMap;
import java.util.Map;

public class CustomerRecords {
	private Map<String, Customer> records;
	
	public CustomerRecords() {
		this.records = new HashMap<String, Customer>();
	}
	
	public void addCustomer(Customer c) {
		this.records.put(c.getName(), c);
	}
		
	public Map<String, Customer> getCustomers() {
		return new HashMap<>(this.records);
		// return Collections.unmodifiableMap(this.records);// <9 this will create copy of object and make it unmodifiable
		//return Map.copyOf(this.records);//> 9 it will just make current object unmodifiable during this action, Performance wise good
	}
}
