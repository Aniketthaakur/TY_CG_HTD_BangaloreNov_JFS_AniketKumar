import java.util.Vector;

public class Vector1 {
public static void main(String[] args) {
	Vector v=new Vector();
	v.add(12);
	v.add(23);
	v.add(43);
	v.add(78);
	System.out.println(v);
	v.remove(new Integer(12));
	System.out.println(v);
	v.set(1, 1);
	System.out.println(v);
	System.out.println("----for -------");
	for(int i=0;i<v.size();i++)
	{
		System.out.println(v.get(i));
	}
	System.out.println("------capacity--------");
	System.out.println(v.capacity());
}
}
