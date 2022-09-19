package com.springcourse.domain;

import java.util.ArrayList;
import java.util.List;

import com.springcourse.domain.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter // - Métodos Set
@Getter // - Métodos Get
@AllArgsConstructor // - Construtor com todos os argumentos
@NoArgsConstructor  // - Construtor com nenhum argumento
public class User {

	private Long id;
	private String name;
	private String email;
	private String password;
	private Role role;
	private List<Request> request = new ArrayList<Request>();
	private List<RequestState> requestState = new ArrayList<RequestState>();

}
