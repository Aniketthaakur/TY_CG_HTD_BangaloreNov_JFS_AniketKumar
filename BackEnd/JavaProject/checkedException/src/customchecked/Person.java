package customchecked;

public class Person {
public static void main(String[] args) {
	Election e1=new Election();
	System.out.println("main started");
	try {
		e1.vote(17);
	} catch (AgeLimitException e) {
		System.out.println(e.getMsg());
	}
	System.out.println("main ended");
}
}
