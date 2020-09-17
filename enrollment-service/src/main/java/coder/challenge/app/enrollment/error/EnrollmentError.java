/**
 * 
 */
package coder.challenge.app.enrollment.error;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author v.huggila
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentError implements Serializable {

	private static final long serialVersionUID = 1L;
	@NonNull
	private String message;
	@NonNull
	private Integer code;

}
