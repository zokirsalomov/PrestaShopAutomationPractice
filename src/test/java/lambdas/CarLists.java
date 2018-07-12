package lambdas;

import java.util.*;
import java.util.function.Predicate;

public class CarLists {

	public static void main(String[] args) {
		
		List< Car > cars = new ArrayList<>();
		cars.add(new Car("Ford Fusion", true , true));
		cars.add(new Car("Chevy Cruze", true, false));
		cars.add(new Car("UberSelfDriving", false, true));
		

//		print(cars, new CheckEngine() {
//			
//					@Override
//					public boolean test(Car car) {
//						
//						return car.isDrivable();
//					}
//				}
//		);
		
		//print(cars, car ->  car.isDrivable() ); 
		
//		print(cars, new Predicate<Car>() {
//
//			@Override
//			public boolean test(Car t) {
//				
//				return t.isDrivable();
//			}
//		});

		print(cars, car -> car.isDrivable());
		
	}
	
	
	public static void print( List<Car> cars, Predicate< Car > engine) {
		
		for (Car each : cars) {
			if(engine.test(each )) {
				System.out.println(each.makeModel + " is drivable: " + engine.test(each));
			}
		}
	}
}

