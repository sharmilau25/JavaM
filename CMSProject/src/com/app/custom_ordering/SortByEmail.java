package com.app.custom_ordering;

import java.util.Comparator;

import com.app.core.Customer;

public class SortByEmail implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		System.out.println("in compare of sort by email");
		return o1.getEmail().compareTo(o2.getEmail());
	}

}
