/**
 * 
 */
package coder.challenge.app.enrollment.persistance.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author v.huggila
 *
 */
@Entity
@Table(name = "t_user_enroll")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enroll_id", nullable = false, updatable = false)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "act_status")
	private String activationStatus;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(name = "phone_num")
	private String phoneNumber;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enroll")
	List<DependantEntity> deps = new ArrayList<>();

}
