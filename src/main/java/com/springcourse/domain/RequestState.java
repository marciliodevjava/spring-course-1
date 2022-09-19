package com.springcourse.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.springcourse.domain.enums.RequestStateEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter // - Métodos Set
@Getter // - Métodos Get
@AllArgsConstructor // - Construtor com todos os argumentos
@NoArgsConstructor  // - Construtor com nenhum argumento
@Entity(name =  "request_stage")
public class RequestState {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "text")
	private String descrition;
	@Column(name = "realization_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date realizationDate;
	@Column(length = 12, nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestStateEnum requestStateEnum;
	@ManyToOne
	@JoinColumn(name = "request_id", nullable = false)
	private Request request;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
