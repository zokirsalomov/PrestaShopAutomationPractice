package lambdas;

public class Car {

	private boolean drivable ;
	private boolean hybrid ;
	public String makeModel; 
	
	
	public Car(String model, boolean drivable, boolean hybrid) {
		this.makeModel = model;
		this.drivable = drivable;
		this.hybrid = hybrid;
	}
	
	public boolean isDrivable() {
		return drivable;
	}
	
	public boolean isHybrid() {
		return hybrid;
	}
}
