package it.beije.neumann.exception;

public class InvalidJwtAuthenticationException extends NeumannException {
	private static final long serialVersionUID = 7575600752056806412L;

	public static final int FORBIDDEN = 403;
	public static final int EXPIRED = 401;
	
	
	private int code;

	public InvalidJwtAuthenticationException(String message, int code) {
		super(message);
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}

}
