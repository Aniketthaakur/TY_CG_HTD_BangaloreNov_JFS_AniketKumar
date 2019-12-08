import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Treemap3  {
public static void main(String[] args) {
	TreeMap<String,ArrayList<Student2>> t=new TreeMap<String,ArrayList<Student2>>();
	
	ArrayList<Student2> a=new ArrayList<Student2>();
	
	a.add(new Student2(20,"Ganesh"));
	a.add(new Student2(22,"anesh"));
	a.add(new Student2(23,"nesh"));
	a.add(new Student2(24,"Ganes"));
	
	t.put("1st Standard",a);
	System.out.println(t.get("1st Standard"));
	Set<Map.Entry<String , ArrayList<Student2>>> s=t.entrySet();
	System.out.println("---------------");	
	for(Map.Entry<String , ArrayList<Student2>> m:s)
	{
		System.out.println(m.getKey());
		System.out.println(m.getValue());
		System.out.println("---------------");
		
		
	}
}
}
