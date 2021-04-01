package customeexceptions;

public class InvalidEnvironementException extends RuntimeException {
	String detailmsg ; 
	public InvalidEnvironementException(String msg) {
		detailmsg = msg;
	}
	public InvalidEnvironementException() {
	 System.err.println("Unable to get envirnoment ,'Invalid Enviroment given'");	
	}
	@Override
	public String toString() {
		String  ClassName = getClass().getName();
		return ClassName+" "+ detailmsg;
	}
	@Override
	public String getMessage() {
		return detailmsg;
			
	}
	 @Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}

}
