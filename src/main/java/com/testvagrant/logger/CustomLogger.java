package com.testvagrant.logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public final class CustomLogger {

	private static final Object SPACE_CONSTANT = " ";

	private Logger logger = null;

	public CustomLogger(Class<?> clazz) {
		logger = LoggerFactory.getLogger(clazz);
	}

	/**
	 * Log an info message. <br/>
	 * The use of concatenated strings in this method is highly discouraged
	 * 
	 * @param message
	 *            {@link String} message to be logged.
	 */

	public void info(String message, Object... parameters) {
		if (logger.isInfoEnabled() && message!=null) {
			if (parameters != null) {
				StringBuilder info = new StringBuilder(message);
				message = perpareMsg(info, parameters);
			}
			logger.info(message);
		}

	}

	/**
	 * Log an error message. <br/>
	 * If there are multiple strings / parameters to be logged - pass down as parameters
	 * 
	 * @param message
	 *            {@link String} message to be logged.
	 */

	public void error(String message, Object... parameters) {
		if (logger.isErrorEnabled() && message != null) {
			if (parameters != null) {
				StringBuilder err = new StringBuilder(message);
				message = perpareMsg(err, parameters);
			}
			logger.error(message);
		}
		assert false : " " + message + " ";
	}

	/**
	 * Log a debug level message .<br/>
	 * If there are multiple strings / parameters to be logged - pass down as parameters
	 * 
	 * @param message
	 * @param parameters
	 */
	public void debug(String message, Object... parameters) {
		if (logger.isDebugEnabled() && message!=null) {
			if (parameters != null) {
				StringBuilder deb = new StringBuilder(message);
				message = perpareMsg(deb, parameters);
			}
			logger.debug(message);
		}

	}

	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}
	
	/**
	 * Log an warning message. <br/>
	 * If there are multiple strings / parameters to be logged - pass down as parameters
	 * 
	 * @param message {@link String} message to be logged.
	 */
	public void warn(String message, Object... parameters) {
		if (logger.isWarnEnabled() && message!=null) {
			if (parameters != null) {
				StringBuilder warn = new StringBuilder(message);
				message = perpareMsg(warn, parameters);
			}
			logger.warn(message);
		}
	}
	
	
	/**
	 * Log a debug level message .<br/>
	 * If there are multiple strings / parameters to be logged - pass down as parameters
	 * 
	 * @param message
	 * @param parameters
	 */
	public void trace(String message, Object... parameters) {
		if (logger.isTraceEnabled()  && message!=null) {
			if (parameters != null) {
				StringBuilder deb = new StringBuilder(message);
				message = perpareMsg(deb, parameters);
			}
			logger.trace(message);
		}

	}
	
	private String perpareMsg(StringBuilder msg, Object... parameters) {
		for (Object o : parameters) {
			if(o != null) {
				msg.append(SPACE_CONSTANT).append(o);	
			}
		}
		return msg.toString();
	}
	
	public static void initializeLogger(String logConfigurationFileName) throws LoggerInitializationFailedException {
		System.out.println("Entering initializeLogger ...");
		try {

			if (StringUtils.isBlank(logConfigurationFileName)) {
				System.err.println("The log file name is null or empty. Logger cannot be configured.");
				throw new LoggerInitializationFailedException(
						"The property root directory is null or empty. Logger cannot be configured.");
			}

			Path logFilePath = Paths.get(logConfigurationFileName);
			File logFile = logFilePath.toFile();

			System.out.println("log4j location: " + logFile);

			// Configure Logger
			if (logFile == null || (logFile != null && !logFile.exists())) {
				System.err.println("Log4J property file was not found! Following basic configuration now");
				BasicConfigurator.configure();
			} else {
				BasicConfigurator.resetConfiguration();
				LogManager.resetConfiguration();
				System.out.println("Initializing log4j with: " + logFile);

				Properties props = new Properties();
				props.load(new FileInputStream(logFile));
				PropertyConfigurator.configure(props);
			}
		} catch (IOException e) {
			System.err.println("An error occurred while trying to configure the logger. Error Trace : \n"
					+ ExceptionUtils.getStackTrace(e));
			throw new LoggerInitializationFailedException("An error occurred while trying to configure the logger. ",
					e);
		} finally {
			System.out.println("Leaving initializeLogger ...");
		}
	}

}
