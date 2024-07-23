package com.nopecommercedemo.browsefactory;

import com.nopecommercedemo.propertyreader.PropertyReader;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ManageBrowser {
   //  public static WebDriver driver;
// private static String baseUrl;
// public ManageBrowser() {
// PageFactory.initElements(driver, this);
// PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/propertiesfile/log4j2.properties");
// }
// public void initializeBaseUrl() {
// String activeProfile = System.getProperty("activatedProfile");
//
// if ("dev".equals(activeProfile)) {
// baseUrl = PropertyReader.getInstance().getProperty("dev.baseUrl");
// } else if ("uat".equals(activeProfile)) {
// baseUrl = PropertyReader.getInstance().getProperty("uat.baseUrl");
// } else if ("devTwo".equals(activeProfile)) {
// baseUrl = PropertyReader.getInstance().getProperty("devTwo.baseUrl");
// } else if ("live".equals(activeProfile)) {
// baseUrl = PropertyReader.getInstance().getProperty("live.baseUrl");
// } else {
// throw new IllegalArgumentException("Invalid or no active profile specified.");
// }
// }
// public void selectBrowser(String browser) throws MalformedURLException {
// if (browser.equalsIgnoreCase("chrome")) {
// ChromeOptions options = new ChromeOptions();
// options.addArguments("--headless"); // Enable headless mode
// options.addArguments("--window-size=1920,1080");
// options.addArguments("--no-sandbox");
// options.addArguments("--disable-dev-shm-usage");
// options.addArguments("--remote-allow-origins=*");
//
// DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
// desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
// driver = new RemoteWebDriver(new URL(" "), desiredCapabilities);
// initializeBaseUrl();
// driver.manage().window().maximize();
// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
// driver.get(baseUrl);
// }
// }
// public void closeBrowser() {
// if (driver != null) {
// driver.quit();
// }
// }











    //Local
    public static WebDriver driver;
    static String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");

    public ManageBrowser() {
        PageFactory.initElements(driver, this);
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/propertiesfile/log4j2.properties");
    }

    public static void selectBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
           // options.addArguments("--headless"); // Enable headless mode
          //options.addArguments("--window-size=1920,1080");
           // options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
 }
        else if (browser.equalsIgnoreCase("firefox"))
 {
	                      FirefoxOptions options=new FirefoxOptions();
	                      //options.addArguments("--headless"); // Enable headless mode
                          //options.addArguments("--window-size=1920,1080");
	                     driver = new FirefoxDriver(options);
	                      System.out.println("The browser is launched in firefox");
 } 
        else if (browser.equalsIgnoreCase("edge"))
        {
        					EdgeOptions edge =new EdgeOptions();
        					//edge.addArguments("--headless");
        					//edge.addArguments("--window-size=1920,1080");
        					driver=new  EdgeDriver(edge);
        					System.out.println("The browser is launched in Edge");
        } else {
            System.out.println("Wrong browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       // driver.get(baseUrl);
        }
       

        
    public static void Selectsite(String baseurl){
    	String siteurl;
    	switch (baseUrl.toLowerCase()){
    	case "dev":
    	siteurl = PropertyReader.getInstance().getProperty("dev.baseUrl");
    	break;
    	case "uat":
    	siteurl = PropertyReader.getInstance().getProperty("uat.baseUrl");
    	break;
    	case "devTwo":
    	siteurl = PropertyReader.getInstance().getProperty("devTwo.baseUrl");
    	break;
    	case "live":
    	siteurl = PropertyReader.getInstance().getProperty("live.baseUrl");
    	break;
    	default:
    	siteurl=baseUrl;
    	break;

    	}
    	driver.get(siteurl);

    	}
}
