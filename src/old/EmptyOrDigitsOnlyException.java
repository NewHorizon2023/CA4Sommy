package old;

public class EmptyOrDigitsOnlyException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptyOrDigitsOnlyException(String fieldName) {
        super(fieldName + " cannot be empty. It cannot have only digits! Please correct this.");
    }
	
}