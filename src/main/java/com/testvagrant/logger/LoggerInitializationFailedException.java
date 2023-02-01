package com.testvagrant.logger;

public class LoggerInitializationFailedException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public LoggerInitializationFailedException(String errorMessage) {
		super(errorMessage);
	}
	
	public LoggerInitializationFailedException(String errorMessage, Throwable e) {
		super(errorMessage, e);
	}
	
}
