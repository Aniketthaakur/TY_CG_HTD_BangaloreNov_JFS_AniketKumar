import java.util.ArrayList;
import java.util.Collection;

public class Collection1 {

	public static void main(String[] args) {
		Collection c1=new ArrayList();
		//adding element into arraylist
		
		c1.add(12);
		System.out.println(c1);
		
		//remove the element from arraylist
		
		c1.remove(12);
		System.out.println(c1);
		
		//finding the size of the array
		
		System.out.println(c1.size());
		
		// finding list is empty or not
		
		System.out.println(c1.isEmpty());
		
		// finding particaular value is present or not
		
		c1.add(12);
		
		System.out.println(c1.contains(12));
		
		
	}
	
}
