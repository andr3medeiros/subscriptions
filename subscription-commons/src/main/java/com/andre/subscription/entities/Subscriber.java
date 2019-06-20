package com.andre.subscription.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import com.andre.subscription.enums.Gender;

import lombok.Data;

@Data
@Entity(name = "subscribers")
public class Subscriber implements Serializable {
	private static final long serialVersionUID = 526338188605776657L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String firstName;
	
	@Column(nullable = false)
	@Email
	private String email;
	
	@Column
	private Date dataOfBirth;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
}
