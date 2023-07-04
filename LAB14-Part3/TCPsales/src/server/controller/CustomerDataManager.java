package server.controller;

import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDataManager {
	
private List<Customer> customers;
	
	/**
	 * Constructor
	 */
	public CustomerDataManager() {
		
		// Load products
		this.customers = new ArrayList<Customer>();
		this.loadCustomers();
		
	}
	
	public List<Customer> getCustomers() {
		
		return customers;
	}
	
	/**
	 * This method finds a customer from a list based on the customer id
	 * and return a customer
	 * @param id
	 * @return a customer
	 */
	public Customer getCustomer(int id) {
		
		// Find a customer
		for (Customer customer:customers) {
			
			if (customer.getCustomerId() == id)
				return customer;
		}
		
		// Return customer not found
		Customer unFoundCustomer = new Customer();
		unFoundCustomer.setCustname("Customer not found");
		
		return unFoundCustomer;
		
	}
	
	/**
	 * This method finds a customer from a list based on the customer name
	 * and return a customer
	 * @param name
	 * @return a customer
	 */
	public Customer getCustomer(String name) {
		
		// Find a customer
		for (Customer customer:customers) {
			
			if (customer.getCustname() == name)
				return customer;
		}
		
		// Return customer not found
		Customer unFoundCustomer = new Customer();
		unFoundCustomer.setCustname("Customer not found");
		
		return unFoundCustomer;
		
	}
	
	/**
	 * This method loads a list of customer into a list
	 */
	private void loadCustomers() {
		// Sample data
				int ids[] = {1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010};
				String names[] = {"Mairah", "Michael", "Firman", "Abu", "May", "John", "Aliiesh", "Wan", "Keisya", "Johnny"};
				
				// Load data into list
				for (int index=0; index < ids.length; index++) {
					
					// Create customer
					Customer customer = new Customer();
					customer.setCustomerId(ids[index]);
					customer.setCustname(names[index]);
					
					// Add to list
					customers.add(customer);
					
				}
		
	}

}
