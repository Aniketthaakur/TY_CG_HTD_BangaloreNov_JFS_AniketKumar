package checkedException;

public class ExceptionA {
public static void main(String[] args) {
	System.out.println("main started");
	try {
		Class c1=Class.forName("Person");
		System.out.println("class is found");
	} catch (ClassNotFoundException e) {
  System.out.println("classs not found");
	}
	System.out.println("main ended");
}
}
