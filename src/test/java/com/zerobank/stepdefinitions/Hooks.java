package com.zerobank.stepdefinitions;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setUp(){
        System.out.println("\tThis is coming from BEFORE");
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }
    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        if(scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
       Thread.sleep(2);
        Driver.closeDriver();
    }
    @Before("@db")
    public void setUpDb(){
        System.out.println("\tConnecting to database...");
    }
    @After("@db")
    public void closeDb(){
        System.out.println("\tDisconnecting to database...");
    }
}
