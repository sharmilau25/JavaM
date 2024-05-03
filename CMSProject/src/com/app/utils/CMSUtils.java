package com.app.utils;

import java.util.List;

import com.app.core.Customer;
import com.app.custom_exceptions.CMSException;

public class CMSUtils {

	public static String deleteCustomerDetails(String email,List<Customer> customersList) throws CMSException {
		//remove using PK, remove(index) or remove(Object)
		int index=customersList.indexOf(new Customer(email));
		if(index == -1)
			throw new CMSException("Cant un subscribe invalid email");
		//valid email
		return "Removed details of "+customersList.remove(index).getFirstName();
	}

	public static Customer authenticateCustomer(String email, String password, List<Customer> list)
			throws CMSException {
		// searching -- by PK --yes --contains | indexOf
		// 1. public int indexOf(Object o)
		// create customer instance -- wrapping email
		Customer newCustomer = new Customer(email);
		int index = list.indexOf(newCustomer);// O(n)
		// 2. invalid email : throw custom exc
		if (index == -1)
			throw new CMSException("Invalid email , Login Failed");
		Customer customer = list.get(index);// O(1)
		// 3. get -- Customer ref --chk pwd --invalid --throw custom exc
//		ret the customer ref
		if (customer.getPassword().equals(password))
			return customer;
		throw new CMSException("Invalid password , Login Failed");

	}
}
