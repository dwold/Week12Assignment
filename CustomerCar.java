package entity;

public class CustomerCar {

	private int customerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerAddress;
	private String customerCity;
	private String customerState;
	private int customerZip;
	private int customerPhoneNumber;
	private int rentcars;
	
	public CustomerCar(int customerId, int rentcars, String customerFirstName, 
			String customerLastName, String customerAddress, String customerCity, 
			String customerState, int customerZip, int customerPhoneNumber) {
		
		this.setCustomerId(customerId);
		this.setCustomerFirstName(customerFirstName);
		this.setCustomerLastName(customerLastName);
		this.setCustomerAddress(customerAddress);
		this.setCustomerCity(customerCity);
		this.setCustomerState(customerState);
		this.setCustomerZip(customerZip);
		this.setCustomerPhoneNumber(customerPhoneNumber);
		this.setRentcars(rentcars);
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public int getCustomerZip() {
		return customerZip;
	}

	public void setCustomerZip(int customerZip) {
		this.customerZip = customerZip;
	}

	public int getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(int customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public int getRentcars() {
		return rentcars;
	}

	public void setRentcars(int rentcars2) {
		this.rentcars = rentcars2;
	}
}
