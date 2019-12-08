import java.util.Collection;
import java.util.HashMap;

public class HashMap2 {
public static void main(String[] args) {
	HashMap<Integer,Student> h=new HashMap<Integer,Student>();
	h.put(34,new Student("divya",22));
	h.put(null, null);
	h.put(null ,new Student("harish",45));
	h.put(43,new Student("shaf",23));
	
	Collection<Student> c1=h.values();
	System.out.println("----------------");
	System.out.println(c1);
	System.out.println("----------------");
	
	for(Student s:c1)
	{
		System.out.println(s);
	}

System.out.println(h.containsKey(34));
System.out.println(h.containsValue(new Student("divya",22)));
System.out.println(h.size());
System.out.println(h.isEmpty());

}
}
