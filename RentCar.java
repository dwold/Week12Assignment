package entity;

public class RentCar {
	private int carId;
	private String carMake;
	private String carModel;
	private int carYear;
	private int carMiles;
	
	public RentCar(int carId, String carMake, String carModel, int carYear, int carMiles) {
		this.setCarId(carId);
		this.setCarMake(carMake);
		this.setCarModel(carModel);
		this.setCarYear(carYear);
		this.setCarMiles(carMiles);
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}
	
	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getCarYear() {
		return carYear;
	}

	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}

	public int getCarMiles() {
		return carMiles;
	}

	public void setCarMiles(int carMiles) {
		this.carMiles = carMiles;
	}
}
