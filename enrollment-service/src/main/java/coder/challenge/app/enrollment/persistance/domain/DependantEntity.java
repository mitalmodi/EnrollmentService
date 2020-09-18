/**
 * 
 */
package coder.challenge.app.enrollment.persistance.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "t_user_dep")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DependantEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dep_id", nullable = false, updatable = false)
	private Long id;
	@Column(name = "name")
	private String name;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "enroll_id")
	private EnrollmentEntity enroll;

}
