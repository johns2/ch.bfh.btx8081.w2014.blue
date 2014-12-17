package ch.bfh.btx8081.w2014.blue.patient.database;

/**
 * Exception class for database package
 * @author R. Ramsauer
 */
public class DataAccessException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataAccessException(String message) {
		super(message);
	}

}
