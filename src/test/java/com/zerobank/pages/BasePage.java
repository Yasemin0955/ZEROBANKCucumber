package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
   @FindBy(id = "signin_button")
    public WebElement signinButton;

    @FindBy(xpath = "//strong[.='Online Banking']")
    public WebElement onlineBanking;


    @FindBy(xpath = "//span[@class='headers']")
    public List<WebElement> headersLink;

    public void goToHeadersPage(String headers){
        onlineBanking.click();
        BrowserUtils.waitFor(2);
        for (int i = 0; i < headersLink.size(); i++) {
          if(headersLink.get(i).getText().equals(headers)){
              headersLink.get(i).click();
          }
        }
    }
}
