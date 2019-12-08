package a;

public class Demo1 {
public static void main(String[] args) {
	String s1="John";
	System.out.println("s1 hashcode is :"+s1.hashCode());
	
	String s2="mikle";
	System.out.println("s2 hascode is:"+s2.hashCode());
	s1="ANiket";
	System.out.println("s1 hashcode is :"+s1.hashCode());
	String s3="John";
	System.out.println("s3 hashcode is :"+s3.hashCode());
}
}
