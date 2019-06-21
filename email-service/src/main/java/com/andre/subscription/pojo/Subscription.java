package com.andre.subscription.pojo;

import java.text.SimpleDateFormat;

import com.andre.subscription.entities.Subscriber;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;

@AllArgsConstructor
public class Subscription {
	@Delegate
	private Subscriber subscriber;
	
	public String getDateOfBirthFormatted() {
		return SimpleDateFormat.getDateInstance(SimpleDateFormat.MEDIUM).format(getDateOfBirth());
	}
}
