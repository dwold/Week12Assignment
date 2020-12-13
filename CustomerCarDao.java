package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CustomerCarDao {

	private static Connection connection;
	
	private final String CREATE_CUSTOMERS_LIST_QUERY = "SELECT * FROM customers";
	private final String DELETE_CAR_BY_ID_QUERY = "DELETE FROM customers WHERE rentcar_id = ?";
	private final String ADD_NEW_CUSTOMER_QUERY = "INSERT INTO customers(rentcar_id, first_name, last_name, address, "
			+ "city, state, zip, phone_number) "
			+ "VALUES (?,?,?,?,?,?,?,?)"; 

	public CustomerCarDao() {
		connection = DBCarConnection.getConnection();
	}

	public void deleteCarById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CAR_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	public void addCustomer( int carId, String firstName, String lastName, String customerAddress, String customerCity,
			String customerState, int customerZip, String customerPhone) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(ADD_NEW_CUSTOMER_QUERY);

		ps.setInt(1, carId);
		ps.setString(2, firstName);
		ps.setString(3, lastName);
		ps.setString(4, customerAddress);
		ps.setString(5, customerCity);
		ps.setString(6,  customerState);
		ps.setInt(7,  customerZip);
		ps.setString(8,  customerPhone);
		
		ps.executeUpdate();
		System.out.println("Customer record has been added.");
		
	}
	
	public void getCustomer() throws SQLException {
			ResultSet rs = connection.prepareStatement(CREATE_CUSTOMERS_LIST_QUERY).executeQuery();
				while (rs.next()) {
					System.out.println(" " + rs.getInt(1) + "\t\t" + rs.getString(3) + " " + rs.getString(4) + "\t\t" + rs.getInt(8));
				}
	}
}
