/**
 * 
 */
package coder.challenge.app.enrollment.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import coder.challenge.app.enrollment.persistance.EnrollmentRepository;
import coder.challenge.app.enrollment.persistance.domain.EnrollmentEntity;
import coder.challenge.app.enrollment.request.EnrollmentRequest;
import io.swagger.v3.oas.annotations.Operation;

/**
 * @author v.huggila
 *
 */
@Validated
@RestController
public class EnrollmentController implements ErrorController {

	@Autowired
	private EnrollmentRepository repository;

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

	@DeleteMapping("/remove/enrolles/{id}")
	public void deleteEnrollers(@PathVariable Long id) {
		repository.deleteById(id);

	}

	@GetMapping("/error")
	@Operation(hidden = true)
	@Override
	public String getErrorPath() {

		return null;
	}

}
