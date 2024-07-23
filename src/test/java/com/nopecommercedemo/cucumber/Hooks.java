package com.nopecommercedemo.cucumber;

import com.cucumber.listener.Reporter;
import com.nopecommercedemo.propertyreader.PropertyReader;
import com.nopecommercedemo.utility.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.NoSuchSessionException;

import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks extends Utility {

    @Before
    public void setUp() throws MalformedURLException {
    	 String browser = System.getProperty("browser");
         if (browser == null || browser.isEmpty()) {
             browser = PropertyReader.getInstance().getProperty("browser");
             if (browser == null || browser.isEmpty()) {
                 throw new IllegalArgumentException("Browser is not specified in the configuration or command line.");
             }
         }

         selectBrowser(browser);

        String baseUrl = System.getProperty("baseUrl");
        if (baseUrl == null || baseUrl.isEmpty()) {
            baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
            if (baseUrl == null || baseUrl.isEmpty()) {
                throw new IllegalArgumentException("Base URL is not specified in the configuration or command line.");
            }
        }

        //SelectSite(baseUrl);
    }
    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            String screenShotPath = Utility.getScreenshot(driver, scenario.getName().replace(" ", "_"));
            try {
                Reporter.addScreenCaptureFromPath(screenShotPath);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchSessionException e) {
                System.out.println("Session not found.");
            } finally {
                Utility.closeWebDriver(driver);
            }
        }
    }


}
