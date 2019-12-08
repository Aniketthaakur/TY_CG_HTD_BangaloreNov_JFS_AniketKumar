package throwandthrows;

public class IRCTC {
	
	void confirmTicket() throws ClassNotFoundException
	{
		try {
			Class.forName("throwandthrows.Paytm");
			System.out.println("Ticket is confirmed");
		} catch (ClassNotFoundException e) {
			System.out.println("TIcket is not confirmed");
			throw e;
		}
	}

}
