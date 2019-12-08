
import java.util.*;

public class HashMap1 {
public static void main(String[] args) {
	HashMap<Integer,String> h1=new HashMap<Integer,String>();
	
	h1.put(12, "suresh");
	h1.put(2, "ramesh");
	Set<Map.Entry<Integer,String>> s1= h1.entrySet();
	
	for(Map.Entry<Integer, String > m:s1)
	{
		System.out.println(m.getKey());
		System.out.println(m.getValue());
		System.out.println("-----------------------");
	}
	

}}
