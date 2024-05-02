package com.app.core;

import java.time.LocalDate;

public class Customer {

	//1.Customer should be assigned system generated (auto increment) customer id : int
		//Store - first name, last name ,email(string),password(string),
		//registrationAmount(double),dob(LocalDate),plan(ServicePlan : enum)
		private int customerId;
		private String firstName;
		private String lastName;
		private String email;
		private String password;
		private double regAmount;
		private LocalDate dob;
		private ServicePlan plan;
		
		//add static field to auto++ customerId 
		private static int idGenerator;

		//add parameterized constructor 
		public Customer(String firstName, String lastName, String email, String password, double regAmount, LocalDate dob,
				ServicePlan plan) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
			this.regAmount = regAmount;
			this.dob = dob;
			this.plan = plan;
			this.customerId=++idGenerator;
		}

		
		
		public Customer(String email) {
			this.email=email;
		}



		//override toString()
		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", email=" + email + ", password=" + password + ", regAmount=" + regAmount + ", dob=" + dob
					+ ", plan=" + plan + "]";
		}



		public int getCustomerId() {
			return customerId;
		}


		public String getFirstName() {
			return firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public String getEmail() {
			return email;
		}


		public String getPassword() {
			return password;
		}


		public double getRegAmount() {
			return regAmount;
		}


		public LocalDate getDob() {
			return dob;
		}

		public ServicePlan getPlan() {
			return plan;
		}



		public void setPassword(String next) {
			// TODO Auto-generated method stub
			
		}
			
}
