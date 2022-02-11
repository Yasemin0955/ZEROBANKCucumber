package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FindTransactionPage extends BasePage{
    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;
    @FindBy(id = "aa_toDate")
    public WebElement toDate;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findButton;
    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//tbody/tr/td[1]")
    public List<WebElement> dates;
    @FindBy(id = "aa_description")
    public WebElement descriptionInput;
    @FindBy(xpath = "(//tbody)[2]/tr/td[2]")
    public List<WebElement> descriptionsColumn;

}
