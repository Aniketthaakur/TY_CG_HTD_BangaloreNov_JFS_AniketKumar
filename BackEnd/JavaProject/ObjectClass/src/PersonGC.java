
public class PersonGC {
String name;

public PersonGC(String name) {
	super();
	this.name = name;
}

@Override
protected void finalize() throws Throwable {
	System.out.println("finallize mehod is called");
	super.finalize();
}

}
