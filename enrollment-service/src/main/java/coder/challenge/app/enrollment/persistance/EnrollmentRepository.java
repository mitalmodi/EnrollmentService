/**
 * 
 */
package coder.challenge.app.enrollment.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import coder.challenge.app.enrollment.persistance.domain.EnrollmentEntity;

/**
 * @author v.huggila
 *
 */
@Repository
public interface EnrollmentRepository extends CrudRepository<EnrollmentEntity, Long> {

}
