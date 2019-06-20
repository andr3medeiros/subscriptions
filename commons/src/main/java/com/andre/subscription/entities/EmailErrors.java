package com.andre.subscription.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.Data;

@Data
@Entity(name = "email_errors")
public class EmailErrors implements Serializable {
	private static final long serialVersionUID = 6681210907437385735L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String error;
	
	@Column(nullable = false)
	@Email
	private String email;
	
	@Column(nullable = false)
	private Date date;
}
