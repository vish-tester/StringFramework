package testNGBasePack;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilsPack.ExtReporter;

public class BaseClass {

	protected Logger logger;
	protected Properties properties = new Properties();
	protected ExtentReports report;
	
	public BaseClass() {
		
		WebDriverManager.chromedriver().setup();
		this.logger=LogManager.getLogger();
	//	this.report = ExtReporter.genExtent();
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                logger.error("Sorry, unable to find config.properties");
                return;
            }
            // Load the properties file
            properties.load(input);
        } catch (IOException ex) {
            logger.error("IOException occurred while loading properties", ex);
        }
	}
	
	public WebDriver instantiateDriver() {
		return WebDriverObject.getDriver();
	}
	
	
	public  Object convertToDataType(String input) {
        // Try to parse as Integer
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // Not an Integer
        }

        // Try to parse as Boolean
        if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(input);
        }

        // If it's not an Integer or Boolean, treat it as a String
        return input;
    }
	
	public void flushExtent() {
	//	report.flush();
	}
	
	public void quitBrowser() {
		WebDriverObject.getDriver().quit();
		}
	
	
	
	
	
	
	
	
}
