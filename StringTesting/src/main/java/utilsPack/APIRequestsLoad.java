package utilsPack;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import testNGBasePack.BaseClass;

public class APIRequestsLoad extends BaseClass {
	private String baseuri = "https://restful-booker.herokuapp.com/booking";
	private String bookingId = "/{b_id}";
	private String TokenUri = "https://restful-booker.herokuapp.com/auth";
	
	public Response getRequest() {
		
		logger.info("Hitting the GET request to fetch every entry");
		return RestAssured.given().contentType(ContentType.JSON).baseUri(baseuri)
		.when().get().then().assertThat().statusCode(200).extract().response();
	}
	
	public Response getRequest(String bookId) {
		
		logger.info("Hitting the GET request with param to fetch respective entry "+bookId);
		return RestAssured.given().contentType(ContentType.JSON).baseUri(baseuri)
		.when().get(bookingId, bookId).then().assertThat().statusCode(200).extract().response();
	}
	
	public Response postRequest(Object body) {
		
		logger.info("Hitting the POST request");
		return RestAssured.given().contentType(ContentType.JSON).baseUri(baseuri).body(body)
		.when().post().then().assertThat().statusCode(200).extract().response();
	}
	
	public String getJWT(String body) {
		
		logger.info("Getting the JSON Web Token");
		Response res =  RestAssured.given().contentType(ContentType.JSON).baseUri(TokenUri).body(body)
		.when().post().then().assertThat().statusCode(200).extract().response();
		
		return res.path("token");
		
	}
	
	public Response putRequest(Object body, String bookId, String token) {
		
		logger.info("Hitting PUT request");
		return RestAssured.given().contentType(ContentType.JSON).baseUri(baseuri).cookie("token",token).pathParam(bookingId, bookId).body(body)
		.when().put(bookingId).then().assertThat().statusCode(200).extract().response();
		
	}
	
	
	public Response patchRequest(Object body, String bookId, String token) {
		
		logger.info("Hitting PATCH request");
		return RestAssured.given().contentType(ContentType.JSON).baseUri(baseuri).cookie("token",token).pathParam(bookingId, bookId).body(body)
				.when().patch(bookingId).then().assertThat().statusCode(200).extract().response();	
		
	}
	
	
	public Response deleteRequest(String bookId, String token) {
		
		logger.info("Hitting DELETE request to delete "+bookId);
		return RestAssured.given().contentType(ContentType.JSON).baseUri(baseuri).cookie("token",token).pathParam(bookingId, bookId)
		.when().delete(bookingId).then().assertThat().statusCode(200).extract().response();
	}
	
	
	
	
	
}
