package testNGBasePack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverObject {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	private WebDriverObject () {
		/*
		 * making it private to restrict
		 * calling constructor from outside the class
		 * 
		 * */
	}
	 
	public static ChromeOptions setChromeOptions () {
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--headless");
		 options.addArguments("--window-size=1200x600");
		 options.setAcceptInsecureCerts(true);
		 
		 return options;
	}
	
	public static WebDriver getDriver() {
		
		if(driver.get()==null)
			synchronized (WebDriverObject.class) {
				if(driver.get()==null)
				{
					driver.set(new ChromeDriver(setChromeOptions()));;
				}
			}
		
		
		return driver.get();
	}
	 
	  
	  
	  
	 
}
