package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.DashboardPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutStepDefs {

    DashboardPage dashboardPage = new DashboardPage();

    @When("user click logout button")
    public void user_click_logout_button() {
        dashboardPage.logOut();
    }

    @Then("user should ends up the {string} page")
    public void user_should_ends_up_the_page(String expectedPage) {
        new DashboardPage().waitUntilLoaderMaskDisappear();
        Assert.assertEquals("Page titles are not same",expectedPage,Driver.get().getTitle());
    }

    @When("user click back button")
    public void userClickBackButton() {
        Driver.get().navigate().back();
    }

    @And("user open a new tab")
    public void userOpenANewTab() {
        BrowserUtils.openNewTab();
    }

    @When("user close the previous tab")
    public void userCloseThePreviousTab() {
        Driver.get().close();
        BrowserUtils.waitFor(1);
        for (String windowHandle : Driver.get().getWindowHandles()) {
            Driver.get().switchTo().window(windowHandle);
            if (Driver.get().getTitle().equals("Untitled")){
                return;
            }
        }
        BrowserUtils.waitFor(1);
    }

    @When("user close the previous tabs")
    public void userCloseThePreviousTabs() {
        String newTab = "";
        BrowserUtils.waitFor(1);
        for (String windowHandle : Driver.get().getWindowHandles()) {
            Driver.get().switchTo().window(windowHandle);
            if (Driver.get().getTitle().equals("Dashboard")){
                Driver.get().close();
            }else{
                newTab = windowHandle;
            }
        }
        Driver.get().switchTo().window(newTab);
    }
}
