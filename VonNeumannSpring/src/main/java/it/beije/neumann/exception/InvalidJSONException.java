package it.beije.neumann.exception;

public class InvalidJSONException extends NeumannException {
	private static final long serialVersionUID = 2949624079837690014L;

	public InvalidJSONException(String message) {
        super(message);
    }
}
