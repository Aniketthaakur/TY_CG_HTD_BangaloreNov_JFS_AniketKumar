import java.util.Vector;

public class Vector2 {
public static void main(String[] args) {
	Vector v=new Vector();
	
	System.out.println(v.size());
	System.out.println(v.capacity());
	v.add(23);
	v.add(56);
	v.add(78);
	v.add(100);
	System.out.println(v.size());
	System.out.println(v.capacity());
	v.trimToSize();
	System.out.println(v.size());
	System.out.println(v.capacity());
	v.setSize(10);
	System.out.println(v.size());
	System.out.println(v);
	v.add(200);
	System.out.println(v);
	System.out.println(v.capacity());
	v.set(5, 100);
	System.out.println(v);
}
}
