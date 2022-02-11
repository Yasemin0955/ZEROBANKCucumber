package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.FindTransactionPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;

public class FindTransactionsDefs {
    FindTransactionPage findTransactionPage=new FindTransactionPage();
    @Given("^the user accesses	the	Find Transactions tab$")
    public void the_user_accessesthefind_transactions_tab() throws Throwable {
    LoginPage loginPage=new LoginPage();
    loginPage.loginWithValidInfo();
    loginPage.goToHeadersPage("Account Activity");
    new AccountActivityPage().findTransactions.click();
    }


    @When("the user enters date range from {string} to {string}")
    public void theUserEntersDateRangeFromTo(String fromDate, String toDate) {
        BrowserUtils.waitFor(2);
        findTransactionPage.fromDate.sendKeys(fromDate);
        findTransactionPage.toDate.sendKeys(toDate);

    }

    @And("clicks search")
    public void clicksSearch() {
        findTransactionPage.findButton.click();
        
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(String fromDate, String toDate) {

        List<String> actualElements = BrowserUtils.getElementsText(findTransactionPage.dates);
        for (String str : actualElements) {
            Assert.assertTrue(str.compareTo(fromDate) >= 0 && str.compareTo(toDate) <= 0);


        }
    }

    @And("the results should be sorted by most recent date")
    public void theResultsShouldBeSortedByMostRecentDate() {
        List<String> actualDates = BrowserUtils.getElementsText(findTransactionPage.dates);
        List<String> expectedDates = BrowserUtils.getElementsText(findTransactionPage.dates);
        Assert.assertEquals(expectedDates,actualDates);
        
    }

    @When("the user enters date from {string} to {string}")
    public void theUserEntersDateFromTo(String arg0, String arg1) {
        
    }

    @And("the results table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String arg0) {
    }
}






    