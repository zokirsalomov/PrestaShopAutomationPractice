package lambdas2;

public class Vehicle {

	
	public String make;
	public String model; 
	
	
	public Vehicle(String make, String model) {
		this.make = make;
		this.model = model;
		 
	}
	
	
	@Override
	public String toString() {
		return "make=" + make + ", model=" + model + "\n";
	}
	
}
