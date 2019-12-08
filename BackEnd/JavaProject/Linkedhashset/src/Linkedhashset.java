import java.util.Iterator;
import java.util.LinkedHashSet;

public class Linkedhashset {
public static void main(String[] args) {
	LinkedHashSet l=new LinkedHashSet();
	l.add(12);
	l.add("aniket");
	l.add(12.34);
	l.add(12);
	l.add(null);
	l.add(null);
	System.out.println(l);
	
	Iterator itr=l.iterator();
	while(itr.hasNext())
	{
		System.out.println(itr.next());
	}
}
}
