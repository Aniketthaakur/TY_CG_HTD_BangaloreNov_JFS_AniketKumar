
public class VehicleClone implements Cloneable {
String name;

public VehicleClone(String name) {
	super();
	this.name = name;
}

@Override
protected Object clone() throws CloneNotSupportedException {
	// TODO Auto-generated method stub
	return super.clone();
}

}
