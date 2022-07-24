package com.pageobjectmodel.pages;

import com.aventstack.extentreports.Status;
import com.pageobjectmodel.customlisteners.CustomListeners;
import com.pageobjectmodel.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    WebElement logo;

    @CacheLookup
    @FindBy(xpath = "//a[@class='ico-account']")
    WebElement myAccountLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logOutLink;

    @CacheLookup
    @FindBy(xpath = "//div[@class='header-menu']/child::ul[1]/li/a")
    List<WebElement> topMenuList;


    public void clickOnLoginLink() {
        CustomListeners.node.log(Status.PASS, "Click on loginLink : " + loginLink.getText());
        Reporter.log("Clicking on login link " + loginLink.getText() + "<br>");
        clickOnElement(loginLink);
    }

    public boolean isLogInLinkDisplay() {
        boolean b = loginLink.isDisplayed();
        CustomListeners.node.log(Status.PASS, "Checking is loginLink displayed : " + loginLink.getText());
        Reporter.log("Checking is loginLink displayed : " + loginLink.getText() + "<br>");
        return b;
    }

    public void clickOnRegisterLink() {
        CustomListeners.node.log(Status.PASS, "Click on registerLink : " + registerLink.getText());
        Reporter.log("Clicking on register link " + registerLink.getText() + "<br>");
        clickOnElement(registerLink);
    }

    public void clickOnMyAccountLink() {
        CustomListeners.node.log(Status.PASS, "Click on myAccountLink : " + myAccountLink.getText());
        Reporter.log("Clicking on myAccountLink : " + myAccountLink.getText() + "<br>");
        clickOnElement(myAccountLink);
    }

    public HomePage clickOnLogOutLink() {
        CustomListeners.node.log(Status.PASS, "Click on logOutLink : " + logOutLink.getText());
        Reporter.log("Clicking on logOutLink : " + logOutLink.getText() + "<br>");
        clickOnElement(logOutLink);
        return new HomePage();
    }

    public boolean isLogOutLinkDisplay() {
        boolean b = logOutLink.isDisplayed();
        CustomListeners.node.log(Status.PASS, "Checking is logOutLink displayed : " + logOutLink.getText());
        Reporter.log("Checking is logOutLink displayed : " + logOutLink.getText() + "<br>");
        return b;
    }

    public boolean isLogoDisplayed() {
        boolean b = logo.isDisplayed();
        CustomListeners.node.log(Status.PASS, "Checking logo is Displayed");
        Reporter.log("Checking logo is Displayed <br>");
        return b;
    }

    public void clickOnMenuTab(String tab) {
        for (WebElement menu : topMenuList) {
            if (menu.getText().contains(tab)) {
                CustomListeners.node.log(Status.PASS, "Click on '" + tab + "' tab");
                Reporter.log("Click on '" + tab + "' tab <br>");
                clickOnElement(menu);
                break;
            }
        }
    }

}
