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
        BrowserUtils.waitFor(2);
        findTransactionPage.fromDate.clear();
        findTransactionPage.toDate.clear();
        findTransactionPage.descriptionInput.clear();
        
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
    @And("the results table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String date) {
        List<String> actualElements = BrowserUtils.getElementsText(findTransactionPage.dates);
        Assert.assertFalse(actualElements.contains(date));
    }

    @When("the user enters description {string}")
    public void theUserEntersDescription(String description) {
        BrowserUtils.waitFor(2);
        findTransactionPage.descriptionInput.sendKeys(description);
        
    }

    @Then("results table should only show descriptions containing {string}")
    public void resultsTableShouldOnlyShowDescriptionsContaining(String expectedDescription) {
        List<String> actualDescriptions = BrowserUtils.getElementsText(findTransactionPage.descriptionsColumn);
        for(String descriptions:actualDescriptions){
        Assert.assertTrue(descriptions.contains(expectedDescription));
    }
    }

    @But("results table should not show descriptions containing {string}")
    public void resultsTableShouldNotShowDescriptionsContaining(String description) {
        List<String> actualDescriptions = BrowserUtils.getElementsText(findTransactionPage.descriptionsColumn);
        Assert.assertFalse(actualDescriptions.contains(description));
    }
}






    