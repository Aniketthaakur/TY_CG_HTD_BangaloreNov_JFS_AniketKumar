package a;

public class TsetyDemo4 {
public static void main(String[] args) {
	Demo4 d=new Demo4("anik",23);
	System.out.println(d.hashCode());
	
	d=new Demo4("aniik",24);
	System.out.println(d.hashCode());
	int age=d.getAge();
	String name=d.getName();
	System.out.println("age is "+age);
	System.out.println("name is "+name  );
}
}
