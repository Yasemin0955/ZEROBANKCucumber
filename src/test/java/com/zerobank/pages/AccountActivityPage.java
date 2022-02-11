package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;

import java.util.List;

public class AccountActivityPage extends BasePage{
    @FindBy(linkText = "Account Activity")
    public WebElement accountActivityLink;
    //it is for Savings
    @FindBy(xpath = "//select[@id='aa_accountId']/option")
    public WebElement accountDropdown;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactions;

    public void verifyAccountDropdown(){

        String[] expectedResults={"Savings","Checking","Loan","Credit Card","Brokerage"};
        List<WebElement> accountOptions = Driver.get().findElements(By.xpath("//select[@id='aa_accountId']/option"));
        for (int i = 0; i < expectedResults.length; i++) {
            Assert.assertEquals(accountOptions.get(i).getText(),expectedResults[i]);

        }
    }
    public void verifyTransactionHeaders(){

        String[] expectedResults={"Date","Description","Deposit","Withdrawal"};
        List<WebElement> actualResults = Driver.get().findElements(By.xpath("//table/thead/tr/th"));
        for (int i = 0; i < expectedResults.length; i++) {
             Assert.assertEquals(actualResults.get(i).getText(),expectedResults[i],"Verify headers");

        }
    }
}
