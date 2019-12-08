import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Treemap1 {
 public static void main(String[] args) {
	 SortingAge a1=new SortingAge();
	TreeMap<Student,String> t=new  TreeMap<Student,String>(new SortingAge());
	
	t.put(new Student(26,"Aniket"), "btm");
	t.put(new Student(25,"Puja"), "Btm");
	t.put(new Student(24,"Asidhd"), "btr");
	t.put(new Student(22,"Simmy"), "rajajinagar");
	
	Set<Map.Entry<Student,String>> s=t.entrySet();
	
	for(Map.Entry<Student,String> m1:s)
	{
		System.out.println(m1.getValue());
		System.out.println(m1.getKey());
		
		System.out.println("-----------------------------------------");
	}
	
	System.out.println(t.get(new Student(26,"aniket")));
}
}
