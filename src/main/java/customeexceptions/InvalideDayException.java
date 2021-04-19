package customeexceptions;

public class InvalideDayException extends RuntimeException{
	String detailmsg;
	public InvalideDayException(String msg) {
	detailmsg= msg;
	}
	public InvalideDayException() {
		System.err.println("Invalide Date Select , Please Select correct date ");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ClassName = getClass().getName(); 
		return ClassName+" "+detailmsg;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return detailmsg;
	}
	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}

}
