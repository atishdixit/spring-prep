package com.ext.prep.perormance.vm.escaping_ref.sol0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomerRecords implements Iterable<Customer>{

	private Map<String, Customer> records;
	
	public CustomerRecords() {
		this.records = new HashMap<String, Customer>();
	}
	
	public void addCustomer(Customer c) {
		this.records.put(c.getName(), c);
	}

	@Override
	public Iterator<Customer> iterator() {
		return records.values().iterator();
	}
}
