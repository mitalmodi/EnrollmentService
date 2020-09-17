/**
 * 
 */
package coder.challenge.app.enrollment.exception;

/**
 * @author v.huggila
 *
 */
public class EnrollmentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public EnrollmentException(String message) {
		super(message);
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
