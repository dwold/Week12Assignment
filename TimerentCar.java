package entity;

public class TimerentCar {
	
	private int id;
	private int rentcars;
	private int customercars;
	private String startDate;
	private String endDate;
	private int milesQty;

	
	public TimerentCar(int id, int rentcars, int customercars, String startDate, String endDate, int milesQty) {		
		this.setId(id);
		this.setRentcars(rentcars);
		this.setCustomercars(customercars);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setMilesQty(milesQty);
	}

	public int getId() {
		return id;
	}

	public void setId(int id2) {
		this.id = id2;
	}
	public int getRentcars() {
		return rentcars;
	}

	public void setRentcars(int rentcars2) {
		this.rentcars = rentcars2;
	}

	public int getCustomercars() {
		return customercars;
	}

	public void setCustomercars(int customercars2) {
		this.customercars = customercars2;
	}
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate2) {
		this.startDate = startDate2;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate2) {
		this.endDate = endDate2;
	}

	public int getMilesQty() {
		return milesQty;
	}

	public void setMilesQty(int milesQty) {
		this.milesQty = milesQty;
	}
}
