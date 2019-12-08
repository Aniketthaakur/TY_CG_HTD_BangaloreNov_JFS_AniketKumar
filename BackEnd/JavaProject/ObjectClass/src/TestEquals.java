
public class TestEquals {
public static void main(String[] args) {
	Equals e1=new Equals("ani",22);
	Equals e2=new Equals("ani",22);
   System.out.println(e1.equals(e2));
   System.out.println(e1.hashCode());
   System.out.println(e2.hashCode());

}
}
