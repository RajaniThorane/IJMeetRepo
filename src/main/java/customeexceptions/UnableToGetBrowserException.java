package customeexceptions;

import java.io.PrintStream;

public class UnableToGetBrowserException extends RuntimeException{
	String message ; 
	public UnableToGetBrowserException(String msg) {
		// TODO Auto-generated constructor stub
		message = msg;
	}
	public UnableToGetBrowserException() {
	 System.err.println("Unable to get Browser Name from File");
	}
	
	@Override
	public String toString() {
		
		String ClassName = getClass().getName(); 
		return ClassName+" "+ message;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}

}
