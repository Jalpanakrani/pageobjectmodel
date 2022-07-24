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

import static com.pageobjectmodel.drivermanager.ManageDriver.driver;


public class ComputerPage extends Utility {

    public ComputerPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(css = "div[class='page-title'] h1")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(xpath = "//div[@class='category-grid sub-category-grid']//h2/a")
    List<WebElement> subMenuLinks;


    public String getPageTitleText() {
        String message = getTextFromElement(pageTitle);
        CustomListeners.node.log(Status.PASS, "Get pageTitle text : " + pageTitle.getText());
        Reporter.log("Get pageTitle text : " + pageTitle.getText() + "<br>");
        return message;
    }

    public void clickOnSubMenu(String subTab) {
        for (WebElement menu : subMenuLinks) {
            if (menu.getText().contains(subTab)) {
                CustomListeners.node.log(Status.PASS, "Click on '" + subTab + "' link");
                Reporter.log("Click on '" + subTab + "' link <br>");
                clickOnElement(menu);
                break;
            }
        }
    }

}
