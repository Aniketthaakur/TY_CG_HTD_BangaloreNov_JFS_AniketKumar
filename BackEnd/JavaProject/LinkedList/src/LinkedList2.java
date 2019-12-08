import java.util.LinkedList;

public class LinkedList2 {
public static void main(String[] args) {
	LinkedList l=new LinkedList();
	l.add(12);
	l.add(23);
	l.add(45);
	l.add(23);
	System.out.println(l);
	//---addFirst and addLast-----
	System.out.println("---addFirst and addLast-----");
	l.addFirst(1);
	l.addLast(100);
	System.out.println(l);
	//-----getFirst and getLast------
	System.out.println("-----getFirst and getLast------");
	System.out.println(l.getFirst());
	System.out.println(l.getLast());
	
	//-------removeFisrt ,remove,removeLast----
	System.out.println("-------remove-----");
  l.remove();
  System.out.println(l);
  System.out.println("----removeFisrt---");
  l.removeFirst();
  System.out.println(l);
  System.out.println("----removeLast---");
  l.removeLast();
  System.out.println(l);
  System.out.println("-----removeFisrtOccarance----");
  l.removeFirstOccurrence(23);
  System.out.println(l);
  System.out.println("-----removelastOccarance----");
  l.removeLastOccurrence(23);
  System.out.println(l);
  
  //-----------peek,peekFirst,peekLast------
  LinkedList l1=new LinkedList();
  l1.add(1);
  l1.add(2);
  l1.add(3);
  l1.add(4);
  l1.add(5);
  System.out.println(l1);
  System.out.println("-----------peek,peekFirst,peekLast------");
  System.out.println(l1.peek());
  System.out.println(l1.peekFirst());
  System.out.println(l1.peekLast());
  //----------poll,pollFisrt,pollLast-------
  System.out.println(l1);
  System.out.println("----------poll,pollFisrt,pollLast-------");
  System.out.println(l1.poll());
  System.out.println(l1);
  System.out.println(l1.pollFirst());
  System.out.println(l1);
  System.out.println(l1.pollLast());
  
  LinkedList l2=new LinkedList();  
  l2.add(13);
  l2.add(34);
  l2.add(89);
  l2.add(67);
  //---------offer,offerFisrt,offerLast---------
  System.out.println(l2);
  System.out.println("---------offer,offerFisrt,offerLast---------");
  System.out.println(l2.offer(100));
  System.out.println(l2);
l2.offerFirst(102);
System.out.println(l2);
l2.offerLast(106);
System.out.println(l2);
  
  
}
}
