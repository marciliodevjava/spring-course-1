package com.springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springcourse.domain.Request;
import com.springcourse.domain.User;
import com.springcourse.domain.enums.RequestStageEnum;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@SpringBootTest
public class RequestRepositoryTest {

	@Autowired
	private RequestRepository requestRepository;

	@Order(1)
	@Test
	public void saveTest() {
		User owner = new User();
		owner.setId(1L);
		Request request = new Request(null, "Notebook DELL", "Core i7 16 GB HD 1Tb", new Date(), RequestStageEnum.OPEN,
				owner, null);

		Request createdRequest = requestRepository.save(request);

		assertThat(createdRequest.getId()).isEqualTo(1L);
	}

	@Order(2)
	@Test
	public void updateTest() {
		User owner = new User();
		owner.setId(1L);
		Request request = new Request(1L, "Notebook DELL", "Core i7 16 GB HD 1Tb - Prata Cromado", null,
				RequestStageEnum.OPEN, owner, null);

		Request updateRequest = requestRepository.save(request);

		assertThat(updateRequest.getDescripiton()).isEqualTo("Core i7 16 GB HD 1Tb - Prata Cromado");

	}

	@Order(3)
	@Test
	public void getByIdTest() {
		Optional<Request> result = requestRepository.findById(1L);
		Request request = result.get();

		assertThat(request.getSubject()).isEqualTo("Notebook DELL");
	}

	@Order(4)
	@Test
	public void lidtTest() {
		List<Request> request = requestRepository.findAll();

		assertThat(request.size()).isEqualTo(1);
	}

	@Order(5)
	@Test
	public void listByOwnerId() {
		List<Request> request = requestRepository.findAllByOwnerId(1L);

		assertThat(request.size()).isEqualTo(1);
	}
	
	@Order(6)
	@Test
	public void updateStatusTest() {
		int affectRows = requestRepository.updateStatus(1L, RequestStageEnum.IN_PROGRESS);
		assertThat(affectRows).isEqualTo(1);
	}
}
