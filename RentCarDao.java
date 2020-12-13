package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.RentCar;

public class RentCarDao {
	
	private Connection connection;
	private final String CREATE_NEW_CAR_QUERY= "INSERT INTO rentcars"
			+ "(car_make, car_model, car_year, car_miles ) VALUES (?, ?, ?, ?)";
	private final String UPDATE_CAR_MILES = "UPDATE rentcars "
			+ "SET car_miles = (car_miles + ?) WHERE id = ?";
	private final String DELETE_CAR_BY_ID_QUERY = "DELETE FROM rentcars WHERE id = ?";
	private final String SHOW_ALL_RENTAL_CARS = "SELECT * FROM rentcars";
		
	public RentCarDao() {
		connection = DBCarConnection.getConnection();
	}
	
	public void createNewCar(String carMake, String carModel, int carYear, int carMiles) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_CAR_QUERY);
		ps.setString(1, carMake);
		ps.setString(2, carModel);
		ps.setInt(3, carYear);
		ps.setInt(4, carMiles);
		
		ps.executeUpdate();

		System.out.println("One car was Added ");
	}
		
	public void updateMiles(int returnMiles, int carRecordId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_CAR_MILES);
		ps.setInt(1, returnMiles);
		ps.setInt(2, carRecordId);
		
		ps.executeUpdate();
		
		System.out.println("Miles updated! ");
	}
	
	public void deleteCarById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CAR_BY_ID_QUERY);
		ps.setInt(1, id);

		ps.executeUpdate();
	}

	public List<RentCar> showAllRentCars() throws SQLException {
		List<RentCar> car = new ArrayList<RentCar>();
		ResultSet rs = connection.prepareStatement(SHOW_ALL_RENTAL_CARS).executeQuery();
		while(rs.next()) {	
			car.add(populateCars(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
		}
		return car;
	}

	private RentCar populateCars(int int1, String string, String string2, int int2, int int3) {
		return new RentCar(int1, string, string2, int2, int3);
	}
}
