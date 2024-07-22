package supportingAPIClasses;

import java.io.File;
import java.io.IOException;

import org.apache.maven.surefire.shared.io.FileUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import utilsPack.APIRequestsLoad;
import utilsPack.FilesConstant;

public class SerializeAndDeSerializeClass extends APIRequestsLoad {

	private BookingDatesPojo bookingdate;
	private BookingPojo booking;
	private String firstname = (String) convertToDataType(properties.getProperty("firstname"));
	private String lastname = (String) convertToDataType(properties.getProperty("lastname"));
	private String additionalneeds = (String) convertToDataType(properties.getProperty("additionalneeds"));
	private int totalprice =  (Integer) convertToDataType(properties.getProperty("totalprice"));
	private boolean depositpaid = (boolean) convertToDataType(properties.getProperty("depositpaid"));
	private ObjectMapper mapper = new ObjectMapper();
	private JsonNode node;
	private FilesConstant filesConstant = new FilesConstant();

	public String createMainPojo() {
		String s = "";
		logger.info("Creating the pojo ");
		bookingdate = new BookingDatesPojo((String) convertToDataType(properties.getProperty("checkin")),
				(String) convertToDataType(properties.getProperty("checkout")));

		booking = new BookingPojo(firstname, lastname, totalprice, depositpaid, additionalneeds, bookingdate);

		logger.info("Booking created " + booking.toString());

		try {
			logger.info("Serializing to JSON String");
			s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
		} catch (JsonProcessingException e) {
			logger.error("Error Parcing the class object to JSON String");
			e.printStackTrace();
		}
		return s;
	}

	public String getBookingId(String response) {
		logger.info("Inside the method: getBookingId");

		try {
			logger.info("Trying to map the json value to jsonNode");
			node = mapper.readTree(response);
		} catch (JsonMappingException e) {
			logger.error("Error in Mapping");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			logger.error("Error in Json Processing");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return node.get("bookingid").asText();
	}

	public String getJSONFromFile(String fileName) {
		logger.info("Inside the method: getJSONFromFile");

		String s = "";
		try {
			logger.info("Reading from file: " + fileName);
			s = FileUtils.readFileToString(new File(filesConstant.basePath + fileName), "UTF-8");
		} catch (IOException e) {

			logger.error("IO Exception happened while reading the file");
			e.printStackTrace();
		}

		return s;
	}

}
