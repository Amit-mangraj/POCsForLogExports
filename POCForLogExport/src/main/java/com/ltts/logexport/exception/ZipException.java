package com.ltts.logexport.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ZipException  extends Exception{

	private static final long serialVersionUID = 1L;
	public ZipException()
	{
		Logger logger = Logger.getLogger(LogException.class.getName());  
		logger.log(Level.INFO, "Zip not created");
	}
}
