import java.util.Vector;

public class Vector3 {
public static void main(String[] args) {
	Vector v=new Vector();
	v.addElement(24);
	v.addElement(56);
	v.addElement(78);
	v.add(67);
	System.out.println(v);
	v.remove(new Integer(24));
	System.out.println(v);
	v.removeElementAt(2);
	System.out.println(v);
	Object i1[]=new Object[v.size()];
	
	v.copyInto(i1);
   for(int i=0;i<i1.length;i++)
   {
	   System.out.println(i1[i]);
   }

}
}
