import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Linked1 {
public static void main(String[] args) {
	LinkedHashMap<String,Integer> h=new LinkedHashMap<String,Integer>();
	h.put("Amurth", 22);
	h.put("BTM", 560076);
	h.put("rajajinager",560070);
	h.put(null, null);
	h.put(null, null);
	
	h.remove("Amurth");
	
	   Set<Map.Entry<String,Integer>> s= h.entrySet();
	   
	   for(Map.Entry<String,Integer> e:s)
	   {
		   System.out.println(e.getKey());
		   System.out.println(e.getValue());
		   
		   System.out.println("-----------------");
	   }
	   
	   System.out.println(h.containsKey("Amruth"));
	   System.out.println(h.containsValue(560076));
	   System.out.println(h.isEmpty());
	   System.out.println(h.size());



}
}
