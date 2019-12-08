import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamFilter {

	public static void main(String[] args) {
		ArrayList<Integer> a=new ArrayList<Integer>();

    a.add(244);
    a.add(7634);
    a.add(8787);
    a.add(3);
    a.add(2);
    
   List<Integer> l= a.stream().filter(i->i%2!=0).collect(Collectors.toList());
   System.out.println(l);
	
	
	System.out.println("-----map-----------");

	   List<Integer> l2= a.stream().map(i->i*100).collect(Collectors.toList());
	   System.out.println(l2);
	   System.out.println("------------max--------------");
	 Optional<Integer> a1= a.stream().max((i,j)->i.compareTo(j));
	 System.out.println(a);
	 System.out.println(a.stream().count());
	}
}
	
