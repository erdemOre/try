package com.fleetgru.stepDefinitions;

import com.fleetgru.pages.DashboardPage;
import com.fleetgru.pages.LoginPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.ConfigurationReader;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class initialTest {

    @Test
    public void test(){
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(1);

//        new LoginPage().login(ConfigurationReader.get("driver_username"),ConfigurationReader.get("password"));
//        DashboardPage dashboardPage = new DashboardPage();
//        dashboardPage.waitUntilLoaderMaskDisappear();
//
//        dashboardPage.logOut();

        BrowserUtils.waitFor(1);
        ;


        BrowserUtils.openNewTab(ConfigurationReader.get("url"));

        BrowserUtils.waitFor(2);
        String origin = Driver.get().getWindowHandle();
        Driver.get().close();
        BrowserUtils.waitFor(1);
        for (String windowHandle : Driver.get().getWindowHandles()) {
            Driver.get().switchTo().window(windowHandle);
            if(Driver.get().getTitle().equals("Untitled")){
                return;
            }
        }
        //Driver.get().get(ConfigurationReader.get("url"));

        Driver.get().findElement(By.id("prependedInput")).sendKeys("asdasdsa");
        BrowserUtils.waitFor(2);
    }

}
