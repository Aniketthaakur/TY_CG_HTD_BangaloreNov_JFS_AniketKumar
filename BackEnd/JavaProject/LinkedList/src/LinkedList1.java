import java.util.*;
public class LinkedList1 {
public static void main(String[] args) {
	LinkedList l=new LinkedList();
	l.add(12);
	l.add(2);
	l.add(23);
	l.add(null);
	l.add(2);
	ListIterator lt=l.listIterator();
	while(lt.hasNext())
	{
		System.out.println(lt.next());
	}
	l.remove(new Integer(2));
	System.out.println(l);
	l.add(54);
	l.add(78);
	//using for loop
	
	for(int i=0;i<l.size();i++)
	{
		System.out.println(l.get(i));
	}
	
	l.add(98);
	System.out.println(l);
	
	//iterate using for each loop

	for(Object i:l)
	{
		System.out.println(i);
	}
	
}
}
