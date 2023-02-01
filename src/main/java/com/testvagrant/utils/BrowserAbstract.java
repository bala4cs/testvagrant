package com.testvagrant.utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class BrowserAbstract{

	public abstract void setDriver(String browserDetails);
	
	public abstract void closeDriver();
	
	public static ThreadLocal<WebDriver> driverThread = new InheritableThreadLocal<WebDriver>();
	
	public static ThreadLocal<JavascriptExecutor> jsExecutorThread = new InheritableThreadLocal<JavascriptExecutor>();

	public WebDriver get() {
		return driverThread.get();
	}

	protected static void setWebDriver(WebDriver driver) {
		// TODO Auto-generated method stub
		driverThread.set(driver);
		jsExecutorThread.set((JavascriptExecutor) driver);
	}

	public static WebDriver getDriver() {
		return driverThread.get();
	}
	
	
	public static JavascriptExecutor getJsExecutorThread() {
		return jsExecutorThread.get();
	}
	
	
}
