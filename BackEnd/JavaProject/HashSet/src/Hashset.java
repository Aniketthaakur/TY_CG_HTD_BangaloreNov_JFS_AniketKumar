import java.util.HashSet;

public class Hashset {
public static void main(String[] args) {
	HashSet hs=new HashSet();
	hs.add(null);
	hs.add(12);
	hs.add(87);
	hs.add(34);
	hs.add(122);
	hs.add(12);
	for(Object obj:hs)
	{

		System.out.println(obj);
	}
	
	System.out.println("---------string type---------");
  HashSet<String> hs1=new HashSet();
    hs1.add("divya");
    hs1.add("anu");
    hs1.add("shreee");
    hs1.add(null);
    for(String s:hs1)
    {
    	System.out.println(s);
    }
    


}
}
