import java.util.ArrayList;
import java.util.List;

public class List3 {
public static void main(String[] args) {
	ArrayList<String> l=new ArrayList();
	l.add("aniket");
	l.add("puja");
	l.add("thakur");
	l.add("amit");
	l.add("Shivam");
	l.add("aman");
	l.add("Bijeet");
	l.add("micku");
	System.out.println(l);
System.out.println(l.size());
System.out.println(l.isEmpty());
System.out.println(l.contains("aniket"));
l.remove(1);
System.out.println(l);
l.add(1,"puja");
System.out.println(l);
ArrayList<String> l1=new ArrayList();
l1.add("aniket");
l1.add("puja");
l1.add("thakur");
l.addAll(1,l1);
System.out.println(l);
ArrayList<String> l2=new ArrayList();
l2.add("aniket");
l2.add("Puja");
l2.add("thakur");
l2.add("amit");
l2.add("shivam");
l2.add("amma");
l2.add("simmy");
l.retainAll(l2);
System.out.println(l);
System.out.println(l2);
l.add("aniket");
System.out.println(l.indexOf("aniket"));
System.out.println(l.lastIndexOf("aniket"));
l.set(2, "Dikhsa");
System.out.println(l);

for(int i=0;i<l.size();i++)
{
	System.out.println(l.get(i));
}
l.set(1, "Puja");
System.out.println(l);
List<String> l3=l.subList(1, 4);
System.out.println(l3);
}
}
