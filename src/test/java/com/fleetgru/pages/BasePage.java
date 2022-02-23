package com.fleetgru.pages;

import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "(//a[@title='Fleet Management'])[2]")
    public WebElement homePageLink;

    public void navigateToHomePage(){
        BrowserUtils.waitForClickablility(By.linkText("Fleet Management"),5);
        homePageLink.click();
    }

    @FindBy(className = "oro-subtitle")
    public WebElement pageSubTitle;

    @FindBy(css = ".loader-mask.shown>.loader-frame")
    @CacheLookup
    protected WebElement loaderMask;

    public void waitUntilLoaderMaskDisappear(){
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(),10);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void navigateTo(String tab, String module){
        Actions actions = new Actions(Driver.get());
        String tabLocator = "//span[normalize-space()='"+tab+"' and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[normalize-space()='"+module+"' and contains(@class, 'title title-level-2')]";

        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);
        }
    }

    @FindBy(css = "#user-menu>a")
    public WebElement myUserName;

    public void logOut(){
        BrowserUtils.waitForClickablility(By.id("user-menu"),10);
        Driver.get().findElement(By.id("user-menu")).click();
        Driver.get().findElement(By.linkText("Logout")).click();
    }


}
