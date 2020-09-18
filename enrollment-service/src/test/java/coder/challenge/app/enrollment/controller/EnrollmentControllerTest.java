/**
 * 
 */
package coder.challenge.app.enrollment.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import coder.challenge.app.enrollment.persistance.EnrollmentRepository;
import coder.challenge.app.enrollment.persistance.domain.EnrollmentEntity;
import coder.challenge.app.enrollment.request.DependentRequest;
import coder.challenge.app.enrollment.request.EnrollmentRequest;

/**
 * @author v.huggila
 *
 */
@Execution(ExecutionMode.SAME_THREAD)
@SpringBootTest
@AutoConfigureMockMvc
public class EnrollmentControllerTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	EnrollmentRepository repository;

	@Autowired
	ObjectMapper objectMapper;

	/**
	 * Test method for
	 * {@link coder.challenge.app.enrollment.controller.EnrollmentController#getEnrollers()}.
	 */
	@Test
	public void testGetEnrollers() throws Exception {

		List<EnrollmentEntity> mockResponse = Arrays.asList(new EnrollmentEntity(1L, "John", "Y",
				Date.from(LocalDate.of(1980, Month.MAY, 10).atStartOfDay(ZoneId.systemDefault()).toInstant()),
				"4153147489", null));
		when(repository.findAll()).thenReturn(mockResponse);

		MvcResult mvcResult = mvc.perform(get("/enrollers")).andDo(print()).andExpect(status().isOk()).andReturn();

		assertEquals(
				"[{\"id\":1,\"name\":\"John\",\"activationStatus\":\"Y\",\"dob\":\"1980-05-09T18:30:00.000+00:00\",\"phoneNumber\":\"4153147489\",\"deps\":null}]",
				mvcResult.getResponse().getContentAsString());

	}

	/**
	 * Test method for
	 * {@link coder.challenge.app.enrollment.controller.EnrollmentController#addEnrollers(coder.challenge.app.enrollment.request.EnrollmentRequest)}.
	 */
	@Test
	public void testAddEnrollers() throws Exception {

		EnrollmentRequest request = new EnrollmentRequest("John", "Y",
				Date.from(LocalDate.of(1980, Month.MAY, 10).atStartOfDay(ZoneId.systemDefault()).toInstant()),
				"4153147489", Arrays.asList(new DependentRequest("Smith", Date
						.from(LocalDate.of(1940, Month.MAY, 10).atStartOfDay(ZoneId.systemDefault()).toInstant()))));

		EnrollmentEntity mockResponse = new EnrollmentEntity(1L, "John", "Y",
				Date.from(LocalDate.of(1980, Month.MAY, 10).atStartOfDay(ZoneId.systemDefault()).toInstant()),
				"4153147489", null);
		when(repository.save(Mockito.anyObject())).thenReturn(mockResponse);

		MvcResult mvcResult = mvc
				.perform(post("/add/enrollers").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andDo(print()).andExpect(status().isOk()).andReturn();

		EnrollmentEntity result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
				EnrollmentEntity.class);

		assertEquals(1L, result.getId());
		assertEquals("John", result.getName());
		assertEquals("4153147489", result.getPhoneNumber());

	}

	/**
	 * Test method for
	 * {@link coder.challenge.app.enrollment.controller.EnrollmentController#deleteEnrollers(java.lang.Long)}.
	 */
	@Test
	public void testDeleteEnrollers() throws Exception {
		List<EnrollmentEntity> mockResponse = Arrays.asList(new EnrollmentEntity(1L, "John", "Y",
				Date.from(LocalDate.of(1980, Month.MAY, 10).atStartOfDay(ZoneId.systemDefault()).toInstant()),
				"4153147489", null));
		when(repository.findAll()).thenReturn(mockResponse);

		mvc.perform(delete("/remove/enrollers/1")).andDo(print()).andExpect(status().isOk()).andReturn();
	}

	/**
	 * Test method for
	 * {@link coder.challenge.app.enrollment.controller.EnrollmentController#getErrorPath()}.
	 */
	@Test
	public void testGetErrorPath() throws Exception {
		mvc.perform(get("/error")).andExpect(status().isOk());
	}

}
