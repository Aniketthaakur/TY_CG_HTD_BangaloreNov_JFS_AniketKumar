package boxingAndUnboxing;

public class TestA {

	public static void main(String[] args) {
		int i=10;
		double d=34.56;
		//Boxing
		Integer i1=new Integer(i);
		Double d1=new Double(d);
		
		//unboxing
	  int i2=i1.intValue();
	  double d2=d1.doubleValue();
	  
	  System.out.println(i);
	  System.out.println(i1);
	  System.out.println(i2);
	  System.out.println(d);
	  System.out.println(d1);
	  System.out.println(d2
			  );
	  
	  
	}
}
