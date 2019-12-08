
public class TestPerson {
public static void main(String[] args) throws Throwable {
  System.out.println("------main method started----------");
  PersonGC p1=new PersonGC("John");
  p1.finalize();
  p1=null;
  System.gc();
  System.out.println("-----main method ended--------");
}
}
