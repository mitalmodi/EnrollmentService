/**
 * 
 */
package coder.challenge.app.enrollment.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NonNull;

/**
 * @author v.huggila
 *
 */
@Data
public class EnrollmentRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NonNull
	private String name;
	@NonNull
	private String activationStatus;
	@NonNull
	private Date dob;
	private String phoneNumber;
	private List<DependentRequest> deps = new ArrayList<>();

}
