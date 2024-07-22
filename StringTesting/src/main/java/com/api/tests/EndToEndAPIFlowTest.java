package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import supportingAPIClasses.SerializeAndDeSerializeClass;

public class EndToEndAPIFlowTest extends SerializeAndDeSerializeClass {

	private String bookingId ;
	
	@BeforeTest
	public void setUp() {
		logger.info("Setting up for API Test Cases");
		
	}
	
	
	@Test 
	public void postNewDataTest() {
		
	String body = createMainPojo();
	logger.info("Send the post request");
	Response res = postRequest(body);
	
	logger.debug("Save booking ID for next step");
	bookingId = getBookingId(res.body().asString());
	
	logger.info("Response code we got is: "+res.getStatusCode());
	
	Assert.assertTrue(res.getStatusCode()==200,"Different Response code "+res.getStatusCode());
	
	}
	
	@Test (dependsOnMethods = "postNewDataTest")
	public void getCreatedRequestInfo() {
		
		logger.info("Send the get request with param as Book ID: "+bookingId);
		Response res = getRequest(bookingId);
		logger.info("Response code we got is: "+res.getStatusCode());
		
		Assert.assertTrue(res.getStatusCode()==200,"Different Response code "+res.getStatusCode());
		
	}
}
