import java.util.TreeSet;

public class TreeSet1 {
public static void main(String[] args) {
	TreeSet t1=new TreeSet();
	t1.add(12);
	t1.add(34);
	t1.add(87);
	t1.add(11);
	t1.add(12);
	t1.remove(87);
	for(Object o1:t1)
	{
		System.out.println(o1);
	}
}
}
