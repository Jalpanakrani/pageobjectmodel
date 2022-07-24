package com.pageobjectmodel.pages;

import com.aventstack.extentreports.Status;
import com.pageobjectmodel.customlisteners.CustomListeners;
import com.pageobjectmodel.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;

    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;

    public String getWelcomeText() {
        String message = getTextFromElement(welcomeText);
        CustomListeners.node.log(Status.PASS, "Get welcomeText : " + welcomeText.getText());
        Reporter.log("Getting welcome text " + welcomeText.getText() + "<br>");
        return message;
    }

    public void enterEmailId(String email) {
        sendTextToElement(emailField, email);
        CustomListeners.node.log(Status.PASS, "Enter EmailId '" + email + "' to email field : "
                + emailField.getText());
        Reporter.log("Enter email " + email + " to email field " + emailField.getText() + "<br>");
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        CustomListeners.node.log(Status.PASS, "Enter Password '" + password + "' to password field : "
                + passwordField.getText());
        Reporter.log("Enter password " + password + " to password field " + passwordField.getText() + "<br>");
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        CustomListeners.node.log(Status.PASS, "Click on loginButton");
        Reporter.log("Clicking on Login Button <br>");
    }

    public String getErrorMessage() {
        String message = getTextFromElement(errorMessage);
        CustomListeners.node.log(Status.PASS, "Get errorMessage : " + errorMessage.getText());
        Reporter.log("Getting error message : " + errorMessage.getText() + "<br>");
        return message;
    }
}
