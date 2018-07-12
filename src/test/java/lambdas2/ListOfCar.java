package lambdas2;


import java.util.*;

public class ListOfCar {

	public static void main(String[] args) {
		
		List< Vehicle > vehicles = new ArrayList<>();
		vehicles.add(new Vehicle("Ford ", "Fusion"));
		vehicles.add(new Vehicle("Chevy", "Cruze"));
		vehicles.add(new Vehicle("Toyota", "Avalon"));
		

//		Comparator< Vehicle > v  = new ModelComparator();
//		Collections.sort(vehicles, v);
		
		//Collections.sort(vehicles, (Vehicle v1, Vehicle v2) -> v1.model.compareTo(v2.model));
		Collections.sort(vehicles, (v1,  v2) -> v1.make.compareTo(v2.make) );

		
	
		
		for (Vehicle each : vehicles) {
			System.out.println(each);
		}
		
			
		 
	}
}


