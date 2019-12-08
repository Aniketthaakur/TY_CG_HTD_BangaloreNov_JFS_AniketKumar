import java.util.Vector;

public class Vector4 {
public static void main(String[] args) {
	Vector v=new Vector();
	
	v.addElement(34);
	v.addElement(56);
	System.out.println(v.size());
	System.out.println(v.capacity());
	v.trimToSize();
	System.out.println(v.size());
	System.out.println(v.capacity());
	v.ensureCapacity(6);
	v.setSize(8);
	System.out.println(v.size());
	System.out.println(v.capacity());
	System.out.println(v);
}
}
