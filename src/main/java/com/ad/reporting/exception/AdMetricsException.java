package com.ad.reporting.exception;

public class AdMetricsException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public AdMetricsException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public AdMetricsException() {
		super();
	}

}
