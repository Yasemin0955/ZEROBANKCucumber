package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigationDefs {
    AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
    @Given("^the user is logged in$")
    public void the_user_is_logged_in()  {

        LoginPage loginPage=new LoginPage();
        loginPage.loginWithValidInfo();
        loginPage.goToHeadersPage("Account Summary");

    }


    @Then("^the Account Activity page should be displayed$")
    public void the_account_activity_page_should_be_displayed()  {
        String expectedTitle="Zero - Account Activity";
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals("not equal",expectedTitle,actualTitle);

    }
    @When("the user clicks on {string} link on the Account Summary page")
    public void theUserClicksOnLinkOnTheAccountSummaryPage(String str) {
        accountSummaryPage.accountSummaryLinks(str).click();
    }
    @And("Account drop down should have {string} selected")
    public void accountDropDownShouldHaveSelected(String str) {
        accountSummaryPage.verifyAccountDropdown(str);
    }



}

