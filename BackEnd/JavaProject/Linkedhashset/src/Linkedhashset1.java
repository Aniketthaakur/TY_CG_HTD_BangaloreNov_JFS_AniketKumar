import java.util.Iterator;
import java.util.LinkedHashSet;

public class Linkedhashset1 {
public static void main(String[] args) {
	LinkedHashSet<Employee> l=new LinkedHashSet();

    l.add(new Employee("aniket",24));
    l.add(new Employee("gunda",24));
    l.add(new Employee("thakur",24));
    l.add(new Employee("aniket",24));
    
    Iterator<Employee> itr=l.iterator();
    while(itr.hasNext())
    {
    	System.out.println(itr.next());
    }

}
}
