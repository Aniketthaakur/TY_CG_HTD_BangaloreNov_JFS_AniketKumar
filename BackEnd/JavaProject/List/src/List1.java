import java.util.*;

public class List1 {
public static void main(String[] args) {
	List l1=new ArrayList();
	
	//method present in the list interface
	l1.add(0,10);
	l1.add(1, 25);
	l1.add(2, 34);
	l1.add(3, 54);
	l1.add(4, 89);
	System.out.println(l1);
	
	l1.remove(2);
	System.out.println(l1);
	
	l1.add(1,210);
	System.out.println(l1);
	System.out.println(l1.indexOf(210));
	l1.add(210);
	System.out.println(l1);
	System.out.println(l1.lastIndexOf(210));
	List l2=new ArrayList();
	l2.add(23);
	l2.add(47);
	l2.add(51);
	System.out.println(l2);
	
	l1.addAll(2,l2);
	System.out.println(l1);
	
	
	for(int i=0;i<l1.size();i++)
	{
		System.out.println(l1.get(i));
	}
	l1.set(1, 93);
	System.out.println(l1);
	List l3=l1.subList(0, 2);
	System.out.println(l3);
	System.out.println(l1);
}
}
