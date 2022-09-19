package com.springcourse.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.springcourse.domain.enums.RequestStateEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter // - Métodos Set
@Getter // - Métodos Get
@AllArgsConstructor // - Construtor com todos os argumentos
@NoArgsConstructor  // - Construtor com nenhum argumento
public class Request{

	private Long id;
	private String subject;
	private String descripiton;
	private Date criationDate;
	private RequestStateEnum state;
	private User user;
	private List<RequestState> requestStage = new ArrayList<RequestState>();
	
	
}
