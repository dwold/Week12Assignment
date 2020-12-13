package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.TimerentCar;

public class TimerentCarDao {

	private Connection connection;
	private final String UPDATE_CAR_MILES = "INSERT INTO timerent("
			+ "rentcar_id, customer_id, start_date, end_date, miles_qty)"
			+ " VALUES (?, ?, ?, ?,?)";
	private final String DELETE_CAR_BY_ID_QUERY = "DELETE FROM timerent WHERE rentcar_id = ?";
	private final String SHOW_ALL_RENTAL_CARS = "SELECT * FROM timerent";
	
	public TimerentCarDao()		{
		connection = DBCarConnection.getConnection();
	}
	
	public void updateCarMiles(int carRecordId, int custRecordId, String rentalStartDate, String rentalReturnDate,
			int returnMiles) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_CAR_MILES);
		ps.setInt(1, carRecordId);
		ps.setInt(2, custRecordId);
		ps.setString(3, rentalStartDate);
		ps.setString(4, rentalReturnDate);
		ps.setInt(5,  returnMiles);
		
		ps.executeUpdate();
		System.out.println("Rental Transaction Dates Added! ");
	}

	public void deleteCarById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CAR_BY_ID_QUERY);
		ps.setInt(1, id);
		
		ps.executeUpdate();
	}
	
	public List<TimerentCar> showAllRentRecords() throws SQLException {
		List<TimerentCar> car = new ArrayList<TimerentCar>();
		ResultSet rs = connection.prepareStatement(SHOW_ALL_RENTAL_CARS).executeQuery();
		
		while(rs.next()) {	
			car.add(populateRentalData(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
		}
			return car;
	}

	private TimerentCar populateRentalData(int int1, int int2, int int3, String string1, String string2, int int4) {
		return new TimerentCar(int1, int2, int3, string1, string2, int4);
	}
}
