package com.springcourse.domain;

import java.util.Date;

import com.springcourse.domain.enums.RequestStateEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter // - Métodos Set
@Getter // - Métodos Get
@AllArgsConstructor // - Construtor com todos os argumentos
@NoArgsConstructor  // - Construtor com nenhum argumento
public class RequestState {

	private Long id;
	private Date realizationDate;
	private String descrition;
	private RequestStateEnum requestStateEnum;
	private Request request;
	private User user;
}
