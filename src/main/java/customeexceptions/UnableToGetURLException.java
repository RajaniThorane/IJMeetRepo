package customeexceptions;

public class UnableToGetURLException extends RuntimeException{

	String message ;
	public UnableToGetURLException() {
	System.err.println("Unsble to get URL From file");	
	}
	public UnableToGetURLException(String msg){
		message =msg;
	}
	@Override
	public String toString() {
		String className = getClass().getName();
				return className + " "+message;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
