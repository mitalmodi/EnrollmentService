/**
 * 
 */
package coder.challenge.app.enrollment.request;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NonNull;

/**
 * @author v.huggila
 *
 */
@Data
public class DependentRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String name;
	@NonNull
	private Date dob;

}
