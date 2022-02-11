package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "user_login")
    public WebElement usernameInput;
    @FindBy(id = "user_password")
    public WebElement passwordInput;
    @FindBy(name = "submit")
    public WebElement loginButton;
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement messageforInvalidInfo;

    public void loginWithValidInfo(){
        signinButton.click();
        BrowserUtils.waitFor(2);
       usernameInput.sendKeys(ConfigurationReader.get("username"));
       passwordInput.sendKeys(ConfigurationReader.get("password"));
       loginButton.click();
       BrowserUtils.waitFor(2);
       Driver.get().navigate().back();
       BrowserUtils.waitFor(2);
    }
    public void loginWithInvalidInfo(){
        signinButton.click();
        usernameInput.sendKeys(ConfigurationReader.get("username"));
        passwordInput.sendKeys("somepassword");
        loginButton.click();
    }
    public void loginWithBlankInfo(){
        signinButton.click();
        loginButton.click();

    }
    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        Driver.get().navigate().to("http://zero.webappsecurity.com/bank/account-summary.html%22");
                BrowserUtils.waitFor(2);
    }

}
