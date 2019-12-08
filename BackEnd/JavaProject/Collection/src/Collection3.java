import java.util.ArrayList;
import java.util.Collection;

public class Collection3 {
public static void main(String[] args) {
	Collection c=new ArrayList();
	c.add(12);
	c.add(25);
	System.out.println(c);
	Collection c1=new ArrayList();
	c1.add(12);
	c1.add(25);
	c1.add(98);
	c1.add(85);
	
	System.out.println(c1);
	c1.removeAll(c1);
	System.out.println("-------after removing all");
	System.out.println(c1);
	Collection c2=new ArrayList();
	c2.add(22);
	c2.add(25);
	c2.add(98);
	c2.add(85);
	System.out.println(c2);
	System.out.println("-----after adding------");
	c.addAll(c2);
	System.out.println(c);
	System.out.println("-----------------------------");
	
	Collection c3=new ArrayList();
	c3.add(25);
	c3.add(23);
	c3.add(86);
	c3.add(98);
	Collection c4=new ArrayList();
	c4.add(25);
	c4.add(23);
	c4.add(12);
	c4.add(13);
	System.out.println(c4);
	c3.retainAll(c4);
	System.out.println(c3);
	System.out.println(c3.containsAll(c4));
 System.out.println(c3);
 c3.clear();
 System.out.println(c3);

// convert arraylist into an array
 System.out.println("-----to array---");
 Collection c5=new ArrayList();
 
 c5.add(12);
 c5.add(13);
 
 Object a[]=c5.toArray();
 for(int i=0;i<a.length;i++)
 {
	 System.out.print(a[i]+" ");
 }
}
}
