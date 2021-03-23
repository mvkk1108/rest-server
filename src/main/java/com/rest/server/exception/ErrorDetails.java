package com.rest.server.exception;

import java.util.Date;

public class ErrorDetails {
	
	private Date timestamp;
	private String message;
	private String path;
	private String status;
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ErrorDetails(Date timestamp, String message, String path, String status) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.path = path;
		this.status = status;
	}
	public ErrorDetails() {
		super();
	}
	
	

}
