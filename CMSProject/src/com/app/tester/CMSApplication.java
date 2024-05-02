package com.app.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.core.Customer;
import com.app.core.ServicePlan;
import com.app.utils.CMSUtils;
import com.app.utils.CMSValidations;

public class CMSApplication {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// init phase
			boolean exit = false;

			// init D.S
			List<Customer> customerList = new ArrayList<Customer>();

			while (!exit) {
				System.out.println("Enter choice\n1.Customer Signup \n2.Display all \n3.Login \n4.Change password \n5.Un subscribe\n0.Exit");
				try {
					switch (sc.nextInt()) {
					case 1:// get user input

						// String firstName, String lastName, String email, String password, double
						// regAmount, LocalDate dob,ServicePlan plan

						System.out.println(
								"Enter user details firstName,  lastName,  email,  password,  regAmount,  dob, plan");
						Customer customer = CMSValidations.validateUserInputs(sc.next(), sc.next(), sc.next(),
								sc.next(), sc.nextDouble(), sc.next(), sc.next(), customerList);
						customerList.add(customer);
						System.out.println("customer registered");
						break;
					case 2:
						// display customers
						for (Customer c : customerList)
							System.out.println(c);
						break;
						
					case 3://login
						System.out.println("Enter email and password:");
						customer=CMSUtils.authenticateCustomer(sc.next(),sc.next(),customerList);
						break;
						
					case 4 : //change password
						System.out.println("Enter email and old password and new password");
						customer=CMSUtils.authenticateCustomer(sc.next(),sc.next(),customerList);
						//change password
						customer.setPassword(sc.next());
						System.out.println("password changed !");
						break;
					case 5:
						System.out.println("Enter email to unsubscribe");
						CMSUtils.deleteCustomerDetails(sc.next(), customerList);
						break;

					case 0:// Exit
						exit = true;
						break;
					}
				} catch (Exception e) {
					sc.nextLine();
					System.out.println(e);
				}
			}
		}

	}

}
