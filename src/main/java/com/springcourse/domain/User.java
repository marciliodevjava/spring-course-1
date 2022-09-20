package com.springcourse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.springcourse.domain.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter // - Métodos Set
@Getter // - Métodos Get
@AllArgsConstructor // - Construtor com todos os argumentos
@NoArgsConstructor  // - Construtor com nenhum argumento
@Entity(name = "user") // Entidade que vai ser mapeada
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automatica de id
	private Long id;
	@Column(length = 75, nullable = false)
	private String name;
	@Column(length = 75, nullable = false,unique = true)
	private String email;
	@Column(length = 100, nullable = false)
	private String password;
	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	@OneToMany(mappedBy = "owner")
	private List<Request> request = new ArrayList<Request>();
	@OneToMany(mappedBy = "owner")
	private List<RequestStage> requestStage = new ArrayList<RequestStage>();

}
