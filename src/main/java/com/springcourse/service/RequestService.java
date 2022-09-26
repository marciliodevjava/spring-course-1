package com.springcourse.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
		Request updateRequest = requestRepository.save(request);
		return updateRequest;
	}
	
	public Request getById(Long id) {
		Optional<Request> result = requestRepository.findById(id);
		return result.get();
	}
	
	public List<Request> getList() {
		List<Request> list = requestRepository.findAll();
		return list;
	}
	
	public List<Request> getListById(Long ownerId) {
		List<Request> result = requestRepository.findAllByOwnerId(ownerId);
		return result;
	}
	// get
	// list
	// list by owner id
}
