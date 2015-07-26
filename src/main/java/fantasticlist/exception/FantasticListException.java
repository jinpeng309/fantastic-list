package fantasticlist.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FantasticListException extends Exception {
	
	private String errCode;
	
	public FantasticListException(){
		super();
	}
	public FantasticListException(String message, String errorCode){
		super(message);
		this.errCode = errorCode;
	}
	public FantasticListException(String message, Throwable cause, String errorCode){
		super(message, cause);
		this.errCode = errorCode;
	}
}
