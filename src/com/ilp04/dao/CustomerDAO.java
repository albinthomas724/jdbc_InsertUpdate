package com.ilp04.dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 
import com.ilp04.entity.Customer;
 
public class CustomerDAO {
    //get connection
	public Connection getConnection() {
		String connectionURL = "jdbc:mysql://localhost:3306/bankdb?useSSL=false";
		String userName = "root";
		String password = "experion@123";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionURL,userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	//close connection
	public Connection closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	//get all customer details
	public ArrayList<Customer> getAllCustomers(Connection connection){
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Statement statement;
		ResultSet resultSet;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from customer");
			while(resultSet.next()) {
				int customerCode = resultSet.getInt(1);
				String customerFirstname = resultSet.getString(2);
				String customerLastname = resultSet.getString(3);
				String address = resultSet.getString(4);
				long phoneNumber = resultSet.getLong(5);
				long aadharNo = resultSet.getLong(6);
				Customer customer = new Customer(customerCode,customerFirstname,customerLastname, address,
			 phoneNumber,  aadharNo);
				customerList.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customerList;
		
	}
	public int insertIntoCustomer(Connection connection, Customer customer) {
        PreparedStatement preparedStatement = null;
        int rowsaffected = 0;
        try {
            String query = "INSERT INTO customer (customer_firstname, customer_lastname, address, phone_number, aadhar_no) " +
                           "VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customer.getCustomerFirstname());
            preparedStatement.setString(2, customer.getCustomerLastname());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setLong(4, customer.getPhNumber());
            preparedStatement.setLong(5, customer.getAadharNo());
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                rowsaffected = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowsaffected;
    }
	public int updateCustomer(Connection connection, Customer customer) {
		// TODO Auto-generated method stub
		 PreparedStatement preparedStatement = null;
	        int rowsaffected = 0;
	        try {
	            String query = "update customer set customer_firstname=?, customer_lastname=?, address=?, phone_number=?, aadhar_no=?";
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, customer.getCustomerFirstname());
	            preparedStatement.setString(2, customer.getCustomerLastname());
	            preparedStatement.setString(3, customer.getAddress());
	            preparedStatement.setLong(4, customer.getPhNumber());
	            preparedStatement.setLong(5, customer.getAadharNo());
	            
	            int rowsAffected = preparedStatement.executeUpdate();
	            if (rowsAffected > 0) {
	                rowsaffected = 1;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (preparedStatement != null) preparedStatement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return rowsaffected;
	}
	
	
//	public int updateCustomer(Connection connection, Customer customer) {
//        
//    }

}