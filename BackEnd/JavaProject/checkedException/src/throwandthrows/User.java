package throwandthrows;

public class User {
	public static void main(String[] args) {
		System.out.println("main started");
		IRCTC i2=new IRCTC();
		Paytm p1=new Paytm(i2);
		p1.confirmTicket();
		System.out.println("main ended");
	}

}
