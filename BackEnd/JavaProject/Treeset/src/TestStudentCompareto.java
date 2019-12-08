import java.util.Iterator;
import java.util.TreeSet;

public class TestStudentCompareto {
public static void main(String[] args) {
	TreeSet<Student> t=new TreeSet<Student>();
  t.add(new Student("aniket",22));
  t.add(new Student("puja",23));
  t.add(new Student("aniket",22));
  t.add(new Student("amit",26));
  
   Iterator<Student> itr=t.iterator();
		   while(itr.hasNext())
		   {
			   System.out.println(itr.next());
		   }
}
}
