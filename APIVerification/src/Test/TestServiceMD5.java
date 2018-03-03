/*
 * Mahmud Hasan Riad
 */


// 

package Test;
import Util.*;

import org.testng.annotations.Test;
import org.testng.Assert;

public class TestServiceMD5 extends Helper{
	
	//check the service response with valid parameter
	@Test
	public void checkResponseWithValidParam(){
		
		String responseBody = getAPIResponse(settings.getParameter(), settings.getParameterValue(),settings.getApiUrl());
		Assert.assertTrue(responseBody.contains("md5"),"wrong response returned by service.");		
	}
	
	//check the service response with invalid parameter
	@Test
	public void checkResponseWithInvalidParam(){
		
		String responseBody = getAPIResponse("InvalidParam", "SampleTextValue",settings.getApiUrl());
		Assert.assertTrue(responseBody.contains("error"),"wrong response given by service without invalid param.");		
	}
	
	//check the service response without parameter
	@Test
	public void checkResponseWithoutParam(){
		
		String responseBody = getAPIResponse("", "",settings.getApiUrl());
		Assert.assertTrue(responseBody.contains("error"),"wrong response given by service without param.");
	}
	
	//check the service response with blank param value.
	@Test
	public void checkResponseWithBlankParamValue(){
		
		String responseBody = getAPIResponse(settings.getParameter(), "", settings.getApiUrl());
		Assert.assertTrue(responseBody.contains("md5"),"wrong response given by service with blank parameter value.");	
	}
	
	//check that returned md5 hash for blank param value is in valid format. 
	@Test
	public void checkMD5HashValueFormat(){
		
		String responseBody = getAPIResponse(settings.getParameter(), "",settings.getApiUrl());
		String md5Value = getJSONKeyValue(responseBody, "md5");
		Assert.assertTrue(md5Value.matches("[\\w+]{32}"),"proper md5 hash is not returned.");
	}
	
	//check the original text returned by service.
	@Test
	public void checkOriginalText(){
		
		String responseBody = getAPIResponse(settings.getParameter(), settings.getParameterValue(),settings.getApiUrl());
		String originalText = getJSONKeyValue(responseBody, "original");
		Assert.assertTrue(originalText.equals(settings.getParameterValue()),"Service returned response for wrong text.");
	}
	
	//check that service returned md5 and java code returned md5 are same.( As md5 are same for same string).
	@Test
	public void crosscheckServiceMD5(){
		
		String responseBody = getAPIResponse(settings.getParameter(), settings.getParameterValue(),settings.getApiUrl());
		String md5HashOfService = getJSONKeyValue(responseBody, "md5");
		String md5HashUsingJavaCode = generateMD5Hash(settings.getParameterValue());
		Assert.assertTrue(md5HashOfService.equals(md5HashUsingJavaCode),"service returned md5 hash and java code returned md5 hash are not equal");
	}
}
