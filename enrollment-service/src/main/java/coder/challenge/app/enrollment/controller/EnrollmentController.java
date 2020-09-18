/**
 * 
 */
package coder.challenge.app.enrollment.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import coder.challenge.app.enrollment.exception.EnrollmentException;
import coder.challenge.app.enrollment.persistance.EnrollmentRepository;
import coder.challenge.app.enrollment.persistance.domain.EnrollmentEntity;
import coder.challenge.app.enrollment.request.EnrollmentRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Value;

/**
 * @author v.huggila
 *
 */
@Validated
@RestController
public class EnrollmentController implements ErrorController {

	@Autowired
	private EnrollmentRepository repository;

	private final String errorPath = "/error";

	@GetMapping("/enrollers")
	public Iterable<EnrollmentEntity> getEnrollers() {
		return repository.findAll();

	}

	@PostMapping("/add/enrollers")
	public EnrollmentEntity addEnrollers(@RequestBody EnrollmentRequest request) {

		EnrollmentEntity enrollmentEntity = new EnrollmentEntity();
		BeanUtils.copyProperties(request, enrollmentEntity);

		return repository.save(enrollmentEntity);

	}

	@DeleteMapping("/remove/enrollers/{id}")
	public void deleteEnrollers(@PathVariable Long id) {
		repository.deleteById(id);

	}

	@GetMapping(value = errorPath)
	@Operation(description = "error", hidden = true)
	public void handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			int statusCode = Integer.parseInt(status.toString());
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				throw new EnrollmentException("Invalid request");
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				throw new EnrollmentException("internal server error");
			}
		}
	}

	@Override
	public String getErrorPath() {

		return errorPath;
	}

}
