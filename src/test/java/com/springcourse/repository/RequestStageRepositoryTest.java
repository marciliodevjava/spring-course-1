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
import com.springcourse.domain.RequestStage;
import com.springcourse.domain.User;
import com.springcourse.domain.enums.RequestStageEnum;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@SpringBootTest
public class RequestStageRepositoryTest {

	@Autowired
	private RequestStageRepository requestStageRepository;

	@Order(1)
	@Test
	public void saveTest() {
		User owner = new User();
		owner.setId(1L);

		Request request = new Request();
		request.setId(1L);

		RequestStage stage = new RequestStage(null, "Fui comprado um novo laptop de marca HD e com 16 GM de ram",
				new Date(), RequestStageEnum.CLOSED, request, owner);

		RequestStage createdStage = requestStageRepository.save(stage);

		assertThat(createdStage.getId()).isEqualTo(1L);
	}

	@Order(2)
	@Test
	public void getByIdTest() {

		Optional<RequestStage> result = requestStageRepository.findById(1L);
		RequestStage stage = result.get();

		assertThat(stage.getDescrition()).isEqualTo("Fui comprado um novo laptop de marca HD e com 16 GM de ram");
	}

	@Order(3)
	@Test
	public void listByRequestIdTest() {
		List<RequestStage> stages = requestStageRepository.findAllByRequestId(1L);

		assertThat(stages.size()).isEqualTo(1);
	}
}
