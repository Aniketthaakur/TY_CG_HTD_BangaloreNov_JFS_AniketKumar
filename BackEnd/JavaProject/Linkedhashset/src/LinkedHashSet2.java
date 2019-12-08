import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSet2 {
	public static void main(String[] args) {
		LinkedHashSet<Integer> l=new LinkedHashSet();
		l.add(12);
		l.add(67);
		l.add(13);
		l.add(12);
		l.add(null);
		l.add(null);
		System.out.println(l);
		
		Iterator<Integer> itr=l.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}

}
