package com.springcourse.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.RequestStage;
import com.springcourse.domain.enums.RequestStageEnum;
import com.springcourse.repository.RequestRepository;
import com.springcourse.repository.RequestStageRepository;

@Service
public class RequestStageService {

	@Autowired
	private RequestStageRepository requestStageRepository;

	@Autowired
	private RequestRepository requestRepository;

	public RequestStage saveRequestStage(RequestStage requestStage) {
		requestStage.setRealizationDate(new Date());
		RequestStage createdStage = requestStageRepository.save(requestStage);
		Long requestId = requestStage.getRequest().getId();
		RequestStageEnum state = requestStage.getRequestStageEnum();
		requestRepository.updateStatus(requestId, state);
		return createdStage;
	}

	public RequestStage getById(Long id) {
		Optional<RequestStage> getRequestById = requestStageRepository.findById(id);
		return getRequestById.get();
	}

	public List<RequestStage> listAllByResquetId(Long id) {
		List<RequestStage> stages = requestStageRepository.findAllByRequestId(id);
		return stages;
	}
}
