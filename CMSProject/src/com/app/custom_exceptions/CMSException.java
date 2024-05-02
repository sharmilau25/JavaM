package com.app.custom_exceptions;

public class CMSException extends Exception {
	public CMSException(String errorMsg)
	{
		super(errorMsg);
	}
}
