/*
 * Mahmud Hasan Riad
 */
package Util;

import java.io.FileInputStream;
import java.util.Properties;

public class Settings {
	
	String apiUrl = "";
	String testngxml = "";
	String parameter = "";
	String parameterValue = "";
	
	/** 
	 * construct setting information
	 **/
	public Settings()
	{
		Properties prop = null;
		try {
			prop = new Properties();
			prop.load(new FileInputStream(Constant.SETTING_PATH));
			
            this.testngxml = prop.getProperty("testngxml");
            this.apiUrl = prop.getProperty("apiUrl");
            this.parameter = prop.getProperty("parameter");
            this.parameterValue = prop.getProperty("parameterValue");
           
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @return the testngxml
	 */
	public String getTestngxml() {
		return testngxml;
	}

	/**
	 * @param testngxml the testngxml to set
	 */
	public void setTestngxml(String testngxml) {
		this.testngxml = testngxml;
	}

	/**
	 * @return the apiUrl
	 */
	public String getApiUrl() {
		return apiUrl;
	}

	/**
	 * @param apiUrl the apiUrl to set
	 */
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	/**
	 * @return the parameter
	 */
	public String getParameter() {
		return parameter;
	}

	/**
	 * @param parameter the parameter to set
	 */
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	/**
	 * @return the parameterValue
	 */
	public String getParameterValue() {
		return parameterValue;
	}
	/**
	 * @param parameterValue the parameterValue to set
	 */
	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}
}
