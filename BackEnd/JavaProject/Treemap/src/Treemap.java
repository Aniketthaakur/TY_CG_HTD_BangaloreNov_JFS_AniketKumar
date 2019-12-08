import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Treemap {
	public static void main(String[] args) {
		TreeMap<Integer,String> t=new TreeMap<Integer,String>();
		
	 t.put(123, "Divya");
	 t.put(56, "shree");
	 t.put(78, "anu");
	 
	 Set<Map.Entry<Integer,String>> s=t.entrySet();
	 
	 for(Map.Entry<Integer,String> m:s)
	 {
		 System.out.println(m.getKey());
		 System.out.println(m.getValue());
		 System.out.println("------------------");
	 }
	}

}
