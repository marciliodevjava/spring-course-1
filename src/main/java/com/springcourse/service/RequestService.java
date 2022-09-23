package com.springcourse.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.Request;
import com.springcourse.domain.enums.RequestStageEnum;
import com.springcourse.repository.RequestRepository;

@Service
public class RequestService {

	@Autowired
	private RequestRepository requestRepository;
	
	// save
	public Request saveRequest(Request request) {
		request.setState(RequestStageEnum.OPEN);
		request.setCriationDate(new Date());
		Request createdRequest = requestRepository.save(request);
		return createdRequest;
		
	}
	// update
	public Request updateRequest(Request request) {
		Request createdRequest = requestRepository.save(request);
		return createdRequest;
	}
	// get
	// list
	// list by owner id
}
