import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class List2 {
public static void main(String[] args) {
	ArrayList<Integer> l1=new ArrayList();
	l1.add(12);
	l1.add(13);
	l1.add(14);
	l1.add(15);
	System.out.println(l1);
	l1.remove(1);
	System.out.println(l1);
	System.out.println("-------for loop-------------");
  for(int i=0;i<l1.size();i++)
  {
	  System.out.println(l1.get(i));
  }
  System.out.println("-----for each loop------");
  for(Integer i1:l1)
  {
	  System.out.println(i1);
  }
  
  System.out.println("-------iterator----");
  Iterator<Integer> itr=l1.iterator();
  while(itr.hasNext())
  {
	  System.out.println(itr.next());
  }
  System.out.println("-------list iterator----------");
  ListIterator<Integer> itrl=l1.listIterator(l1.size());
  while(itrl.hasPrevious())
  {
	  System.out.println(itrl.previous());
  }
 System.out.println("-------list itrartor next+previous ");
 
 ListIterator<Integer> itrl1=l1.listIterator();
 while(itrl1.hasNext())
 {
	 System.out.println(itrl1.next());
	 
 }
 System.out.println("-------------");
while(itrl1.hasPrevious())
{
	System.out.println(itrl1.previous());
}
System.out.println("------remove using index + object---------");
ArrayList<Integer> l2=new ArrayList();
l2.add(12);
l2.add(13);
System.out.println(l2);
System.out.println("----remove using index-------");
l2.remove(0);
System.out.println(l2);
l2.add(0,12);
System.out.println(l2);
System.out.println("-----remove using object-----");
l2.remove(new Integer(13));
System.out.println(l2);
}
}
