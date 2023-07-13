package com.ext.prep.perormance.vm.escaping_ref.sol0;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		CustomerRecords records = new CustomerRecords();

		records.addCustomer(new Customer("John"));
		records.addCustomer(new Customer("Simon"));
		for (Customer next :records){
			System.out.println(next);
		}


//		Iterator<Customer> customers = records.iterator();
//		customers.next();
//		customers.remove();
//
//		for (Customer next :records){
//			System.out.println(next);
//		}

		//Still we have problem , only if anyone intentionally  wants to remove
	}
	
}
