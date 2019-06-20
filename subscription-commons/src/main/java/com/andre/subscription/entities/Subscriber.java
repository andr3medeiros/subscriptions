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
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "subscribers")
public class Subscriber implements Serializable {
	private static final long serialVersionUID = 526338188605776657L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String firstName;
	
	@Column(nullable = false)
	@Email
	private String email;
	
	private Date dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private boolean subscribed = true;
}
