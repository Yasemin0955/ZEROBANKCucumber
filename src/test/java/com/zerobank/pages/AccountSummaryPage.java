package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountSummaryPage extends BasePage{
    @FindBy(linkText = "Account Summary")
    public WebElement acccountSummary;

    @FindBy(linkText = "Savings")
    public WebElement savingsLink;

    @FindBy(id = "aa_accountId")
    public WebElement accountDropdown;
    @FindBy(linkText = "Brokerage")
    public WebElement brokerageLink;




    public void verifyAccountTypes(){
        String[] expectedTypes={"Cash Accounts","Investment Accounts","Credit Accounts","Loan Accounts"};
        List<WebElement> allAccountTypes = Driver.get().findElements(By.xpath("//h2[@class='board-header']"));
        for(int i=0;i<expectedTypes.length;i++){
            Assert.assertEquals(allAccountTypes.get(i).getAttribute("innerHTML"),expectedTypes[i],"Verify Acoount types ");
        }
    }

    public void creditAccountOptions(){
        String[] expectedOptions={"Account","Credit Card","Balance"};
        List<WebElement> options = Driver.get().findElements(By.xpath("(//table)[3]/thead/tr/th"));
        for(int i=0;i< expectedOptions.length;i++){
            Assert.assertEquals(options.get(i).getText(),expectedOptions[i],"Verify credit account options");
        }
    }
    public void verifyAccountDropdown(String option){
        Select select=new Select(accountDropdown);
        String firstSelectedOption = select.getFirstSelectedOption().getText();
        String expectedOption=option;
        Assert.assertEquals(option+" is not displayed",expectedOption,firstSelectedOption);
    }
     public WebElement accountSummaryLinks(String linkText){
        return Driver.get().findElement(By.linkText(linkText));
     }
}
