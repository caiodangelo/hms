package com.uff.hmstpa.util.exception;

@SuppressWarnings("serial")
public class BusinessRuleException extends Exception {
	
	private Object location;
	
	public BusinessRuleException(Object location, String msg) {
		super(msg);
		this.location = location;
	}
	
	public Object getLocation() {
		return location;
	}
	
}
