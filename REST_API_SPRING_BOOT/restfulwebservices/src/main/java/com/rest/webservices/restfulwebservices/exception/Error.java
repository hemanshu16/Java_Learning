package com.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

public class Error {
	
	private LocalDateTime timestamp;
	private String message;
	private String description;
	public Error(LocalDateTime timestamp, String message, String description) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDescription() {
		return description;
	}
	
}
