
public class TestVehicle {
public static void main(String[] args) throws CloneNotSupportedException {
	VehicleClone v1= new VehicleClone("Benz");
	Object o1=v1.clone();
	VehicleClone v2=(VehicleClone)o1;
	System.out.println(v2.name);
}
}
