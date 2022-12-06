package com.restfull.oop.exception.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class BadRequestAlertException extends AbstractThrowableProblem {
	
	private static final long serialVersionUID = 1L;
	
	private final String entityName;
	
	private final String errorKey;
	
	public BadRequestAlertException(String defaultMessage, String entityName, String errorKey) {
		this(ErrorConstants.DEFAULT_TYPE, defaultMessage, entityName, errorKey);
	}
	
	public BadRequestAlertException(URI type, String defaultMessage, String entityName, String errorKey) {
		super(type, defaultMessage, Status.BAD_REQUEST, null, null, null, getAlertParameters(entityName, errorKey, null));
		this.entityName = entityName;
		this.errorKey = errorKey;
	}
	
	public BadRequestAlertException(ErrorEnum error) {
		this(error, null);
	}
	
	public BadRequestAlertException(ErrorEnum error, Object data) {
		super(null,null, Status.BAD_REQUEST, null, null, null, getAlertParameters(error.getEntityName(), error.getErrorKey(), data));
		this.entityName = error.getEntityName();
		this.errorKey = error.getErrorKey();
	}
	
	public String getEntityName() {
		return entityName;
	}
	
	public String getErrorKey() {
		return errorKey;
	}
	
	private static Map<String, Object> getAlertParameters(String entityName, String errorKey, Object data) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("message", "error" +entityName+ errorKey);
		parameters.put("params", entityName);
		parameters.put("data", data);
		return parameters;
	}
}
