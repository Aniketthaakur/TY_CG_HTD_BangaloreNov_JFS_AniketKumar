package customchecked;

public class AgeLimitException extends Exception {
	String msg="age should be more then 18 ";

	public AgeLimitException() {
		super();
	}

	public AgeLimitException(String msg) {
		super();
		this.msg = msg;
	}
         
	public String getMsg() {
		return msg;
	}
	
	

}
