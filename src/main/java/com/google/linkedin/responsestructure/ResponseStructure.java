package com.google.linkedin.responsestructure;

public class ResponseStructure 
{
	private int status;
	private String message;
	private Object body;
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	
	
	public ResponseStructure() {
		super();
		
	}
	
	public ResponseStructure(int status, String message, Object body) 
	{
		super();
		this.status = status;
		this.message = message;
		this.body = body;
	}
}