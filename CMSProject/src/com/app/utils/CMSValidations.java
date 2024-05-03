package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.app.core.Customer;
import com.app.core.ServicePlan;
import com.app.custom_exceptions.CMSException;

public class CMSValidations {
	private static void checkForDupCustomer(String email, List<Customer> customerList) throws CMSException {
		// create customer class instance wrapping PK
		Customer newCust = new Customer(email);
		// invoke contains using the customer ref
		if (customerList.contains(newCust))
			throw new CMSException("duplicate email!!");

	}

	private static ServicePlan parseAndValidatePlanAndCharges(String plan, double regAmount) throws CMSException {
		// parse String(plan)=>enum
		ServicePlan servicePlan = ServicePlan.valueOf(plan.toUpperCase());
		// plan is valid then check if reg amount is correct
		if (servicePlan.getPlanCost() == regAmount) {
			return servicePlan;
		}
		throw new CMSException("Reg amount dosent match with the chosen plan cost");

	}

	public static Customer validateUserInputs(String firstName, String lastName, String email, String password,
			double regAmount, String dob, String plan, List<Customer> customers) throws CMSException {
		// check for duplicates
		checkForDupCustomer(email, customers);
		ServicePlan servicePlan = parseAndValidatePlanAndCharges(plan, regAmount);
		LocalDate birthDate = LocalDate.parse(dob);
		parseAndValidateBirthDate(dob);
		validatePassword(password);
		// if all inputs are valid , return validated customer details to the caller

		return new Customer(firstName, lastName, email, password, regAmount, birthDate, servicePlan);
	}

	public static void validatePassword(String password) throws CMSException {
		// declare in static inti block
		String passwordRegex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[#@$*]).{5,20})";
		if (!password.matches(passwordRegex))
			throw new CMSException("Invalid password");

	}

	//for Customer must not be minor (age >21)
	public static LocalDate parseAndValidateBirthDate(String dob)throws CMSException {
		
		LocalDate birthdate=LocalDate.parse(dob);
		//LocalDate age = Period.between(birthdate, LocalDate.now().getYear());
		return birthdate;

	}

}
