import java.util.HashSet;

public class Hashset2 {
public static void main(String[] args) {
	HashSet<Student> h=new HashSet<Student>();
    h.add(new Student("Anu",22));
    h.add(new Student("shree",23));
    h.add(new Student("Anu",22));
    h.add(new Student("shree",24));
    System.out.println();
    
    for(Student s:h)
    {
    	System.out.println(s.studName+ "     and age is :"+s.age);
    }

}
}
