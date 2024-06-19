package com.ilp04.utility;

import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;
import com.ilp04.service.CustomerServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerUtility {
    private static final Scanner sc = new Scanner(System.in);
    private static final CustomerService customerService = new CustomerServiceImpl();

    public static void main(String[] args) {
        char goToMainMenu;
        do {
            System.out.println("Enter your choice: 1. Display all Customers 2. Insert new customer 3. Update customer");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    getAllCustomers();
                    break;
                case 2:
                    insertIntoCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            System.out.println("Go to main menu (y/n)");
            goToMainMenu = sc.next().charAt(0);
        } while (goToMainMenu == 'y');

        sc.close();
    }

    private static void updateCustomer() {
		// TODO Auto-generated method stub
    	System.out.println("Enter the customer code :");
    	int customerCode=sc.nextInt();
    	
    	System.out.println("Enter first name:");
        String fname = sc.next();
        System.out.println("Enter last name:");
        String lname = sc.next();
        System.out.println("Enter address:");
        String address = sc.next();
        System.out.println("Enter Phone number:");
        long phnumber = sc.nextLong();
        System.out.println("Enter aadhar number:");
        long aadhar_no = sc.nextLong();

        Customer customer = new Customer(customerCode, fname, lname, address, phnumber, aadhar_no);
        int rowsAffected = customerService.updateCustomer(customer);

        if (rowsAffected > 0) {
            System.out.println("Inserted successfully");
        } else {
            System.out.println("Insertion failed");
        }
		
	}

	private static void getAllCustomers() {
        ArrayList<Customer> customerList = customerService.getAllCustomers();
        for (Customer customer : customerList) {
            System.out.println("Customer Code: " + customer.getCustomerCode());
            System.out.println("Customer First Name: " + customer.getCustomerFirstname());
            System.out.println("Customer Last Name: " + customer.getCustomerLastname());
            
        }
    }

    private static void insertIntoCustomer() {
        System.out.println("Enter the customer code:");
        int customerCode = sc.nextInt();
        System.out.println("Enter first name:");
        String fname = sc.next();
        System.out.println("Enter last name:");
        String lname = sc.next();
        System.out.println("Enter address:");
        String address = sc.next();
        System.out.println("Enter Phone number:");
        long phnumber = sc.nextLong();
        System.out.println("Enter aadhar number:");
        long aadhar_no = sc.nextLong();

        Customer customer = new Customer(customerCode, fname, lname, address, phnumber, aadhar_no);
        int rowsAffected = customerService.insertIntoCustomer(customer);

        if (rowsAffected > 0) {
            System.out.println("Inserted successfully");
        } else {
            System.out.println("Insertion failed");
        }
    }


//    private static void updateCustomer() {
//        System.out.println("Enter customer code:");
//        int customerCode = sc.nextInt();
//
//        System.out.println("Enter field to update (first_name, last_name, address, phone_number, aadhar_no):");
//        String updateField = sc.next();
//
//        // Depending on the updateField, prompt user for new value
//        String newValue;
//        switch (updateField) {
//            case "first_name":
//            case "last_name":
//            case "address":
//                System.out.println("Enter new value:");
//                newValue = sc.next();
//                break;
//            case "phone_number":
//            case "aadhar_no":
//                System.out.println("Enter new value:");
//                newValue = sc.nextLong();
//                break;
//            default:
//                System.out.println("Invalid field.");
//                return;
//        }
//
//        Customer customer = new Customer();
//        customer.setCustomerCode(customerCode);
//        customer.setUpdateField(updateField);
//
//        // Set the appropriate value based on the updateField
//        switch (updateField) {
//            case "first_name":
//                customer.setCustomerFirstname(newValue);
//                break;
//            case "last_name":
//                customer.setCustomerLastname(newValue);
//                break;
//            case "address":
//                customer.setAddress(newValue);
//                break;
//            case "phone_number":
//                customer.setPhNumber(Long.parseLong(newValue));
//                break;
//            case "aadhar_no":
//                customer.setAadharNo(Long.parseLong(newValue));
//                break;
//        }
//
//        int rowsAffected = customerService.updateCustomer(customer);
//        if (rowsAffected > 0) {
//            System.out.println("Update successful");
//        } else {
//            System.out.println("Update failed");
//        }
//    }
}
