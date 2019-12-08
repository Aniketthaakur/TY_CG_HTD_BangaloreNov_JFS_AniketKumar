import java.util.LinkedList;

public class LinkedList3 {
public static void main(String[] args) {
	LinkedList l=new LinkedList();
	l.add(12);
	l.add(23);
	l.add(45);
	l.add(54);
	System.out.println(l);
	//------push,pop,element--------
	System.out.println("------push,pop,element--------");
	l.push(89);
	System.out.println(l);
	l.pop();
	System.out.println(l);
	
	System.out.println(l.element());
}
}
