package com.ltts.logexport.exception;

import java.util.logging.Logger;

import java.util.logging.Level;

public class LogException extends Exception{
	private static final long serialVersionUID = 1L;

	public LogException(){
		Logger logger = Logger.getLogger(LogException.class.getName());  
		logger.log(Level.SEVERE, "Logs Not Found"); //user defined exception
	}
	
}