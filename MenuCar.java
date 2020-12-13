package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CustomerCarDao;
import dao.RentCarDao;
import dao.TimerentCarDao;
import entity.CustomerCar;
import entity.RentCar;
import entity.TimerentCar;

public class MenuCar {
	private RentCarDao rentcarDao = new RentCarDao();
	private TimerentCarDao timerentCarDao = new TimerentCarDao();
	private CustomerCarDao customerCarDao = new CustomerCarDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Add a Car",
			"Add a Customer",
			"Update Car Transaction",
			"Display Car Rental Records",
			"Display All Cars",
			"Read a Customer",
			"Delete a Car");
				
	public void enter() {
	
	String selection = " ";	

	do {
		printMenu();
		selection = scanner.nextLine();
		try {
			if (selection.equals("1")){
				createCar();
			}else if (selection.equals("2")) {
				addCustomer();
			} else if (selection.equals("3")) {
				updateCar();
			} else if (selection.equals("4")) {
				displayCarRentalRecords();
			}else if (selection.equals("5")) {
				showAllCars();
			}else if (selection.equals("6")) {
				readCustomers();
			}else if (selection.equals("7")) {
				deleteCar();
			}
			
	} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Press enter to continue...");
		System.out.println("Option (-1) to exit Application.");
		scanner.nextLine();
			
		
	}while (!selection.equals("-1"));
	
}
	


private void printMenu() {
	System.out.println(" \t\t  Rent A Car Program");
	System.out.println(" \t\t ********************");
	System.out.println("Authors: Dagnachew Woldeyohannes, Sri Srinivasan and Adrian Aguero ");
	System.out.println(" ");
	
	System.out.println("Select an Option: \n ...................");
	for (int i=0; i<options.size(); i++) {
		System.out.println(i + 1 + ")" + options.get(i));
	}
	}

	private void createCar() throws SQLException {
		System.out.print("Enter car make:  ");
		String carMake = scanner.nextLine();
		System.out.print("Enter car model:  ");
		String carModel = scanner.nextLine();
		System.out.print("Enter car year:  ");
		int carYear = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter car miles:  ");	
		int carMiles = Integer.parseInt(scanner.nextLine());
		rentcarDao.createNewCar(carMake, carModel, carYear, carMiles);
	}

	private void readCustomers() throws SQLException {
		System.out.println("Cust Id:   Cust Full Name:\t Phone Number");
		System.out.println("-------------------------------------------------------------");
		customerCarDao.getCustomer();
	}
	
	private void updateCar() throws SQLException {
		System.out.println("You selected Update Car Miles: \n");
		System.out.print("Please enter the Car Record ID: ");
		int carRecordId = scanner.nextInt();
		System.out.print("Please enter the Customer Record ID now: ");
		int custRecordId = scanner.nextInt();
		System.out.println("Next we will enter the dates: \n");
		scanner.nextLine();

		System.out.print("Now enter the Start Date for the Car Rental: ");
		String rentalStartDate = scanner.nextLine();
		System.out.print("Please enter the Date of Return for the Car: ");
		String rentalReturnDate = scanner.nextLine();
		System.out.print("Please enter the mileage of the Car: ");
		int returnMiles = scanner.nextInt();
	
		timerentCarDao.updateCarMiles(
			carRecordId, custRecordId, rentalStartDate,
			rentalReturnDate, returnMiles);
		rentcarDao.updateMiles(returnMiles, carRecordId);
	}

	private void deleteCar() throws SQLException {
		System.out.print("Enter car id to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		timerentCarDao.deleteCarById(id);
		customerCarDao.deleteCarById(id);
		rentcarDao.deleteCarById(id);
		System.out.println("Car record deleted successfully.");
	}
	
	private void displayCarRentalRecords() throws SQLException {
		List<TimerentCar> car = timerentCarDao.showAllRentRecords();
		System.out.println("Id:\tCar ID:\t  CustomerID:\t\tStart Date:\tEndDate:\tMiles");
		System.out.println("---------------------------------------------------------------------------------------------------");
		for ( TimerentCar c : car ) {
			String result = (c.getId() + "\t" + c.getRentcars() + "\t\t" + c.getCustomercars() + "\t\t" + c.getStartDate() + "\t" + c.getEndDate() + "\t" +  c.getMilesQty());
			System.out.println(result);
		}
	}

	private void showAllCars() throws SQLException {
		System.out.println("Showing all Cars!\n");
		System.out.format("%-2s %12s %12s %10s %10s \n", "Id:", "Car Make:", "Car Model:", "Year:", "Miles");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		List<RentCar> car = rentcarDao.showAllRentCars();
		for ( RentCar c : car ) {
			System.out.format("%-2s %12s %12s %10s %10s", c.getCarId(), c.getCarMake(), c.getCarModel(), c.getCarYear(), c.getCarMiles());
			System.out.println();
		}
	}

	private void addCustomer() throws SQLException {
		System.out.print("Enter customer first name:  ");
		String firstName = scanner.nextLine();
		System.out.print("Enter customer last name:  ");
		String lastName = scanner.nextLine();
		System.out.print("Enter customer address:  ");
		String customerAddress = scanner.nextLine();
		System.out.print("Enter customer city:  ");
		String customerCity = scanner.nextLine();
		System.out.print("Enter Customer State:  ");
		String customerState = scanner.nextLine();
		System.out.print("Enter Customer Zip Code:  ");
		int customerZip = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter Customer Phone:  ");
		String customerPhone = scanner.nextLine();
		System.out.print("Please enter Car Id (Car should exist in the rental car table):  ");
		int carId = scanner.nextInt();
	
		customerCarDao.addCustomer(carId, firstName, lastName, customerAddress, customerCity, customerState, 
				customerZip, customerPhone);
		System.out.println("Completed adding customer.");
	}

}	
	
	

