package com.ext.prep.perormance.vm.escaping_ref.obj.sol1;

public class Main {

	public static void main(String[] args) {
		CustomerRecords records = new CustomerRecords();
		records.addCustomer(new Customer("John"));
		records.addCustomer(new Customer("Simon"));

		System.out.println(records.findByName("John"));

		//Problem here you can chages
		//records.findByName("John").setName("Hello");//CTE
		//System.out.println(records.findByName("John"));
	}
}
