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

public class DesktopsPage extends Utility {

    public DesktopsPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(css = "div[class='page-title'] h1")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(id = "products-orderby")
    WebElement sortBy;

    @CacheLookup
    @FindBy(id = "products-pagesize")
    WebElement display;

    @CacheLookup
    @FindBy(xpath = "//div[@class='products-container']//h2/a")
    List<WebElement> productTitleList;


    public String getPageTitleText() {
        String message = getTextFromElement(pageTitle);
        CustomListeners.node.log(Status.PASS, "Get pageTitle text : " + pageTitle.getText());
        Reporter.log("Get pageTitle text " + pageTitle.getText() + "<br>");
        return message;
    }

    public void selectSortBy(String position) {
        selectByVisibleTextFromDropDown(sortBy, position);
        CustomListeners.node.log(Status.PASS, "Sort by '" + position + "' position");
        Reporter.log("Sort by '" + position + "' position <br>");
    }

    public void selectDisplayPerPage(String number) {
        selectByVisibleTextFromDropDown(display, number);
        CustomListeners.node.log(Status.PASS, "Display product '" + number + "' per page");
        Reporter.log("Display product '" + number + "' per page <br>");
    }

    public void selectProduct(String productName) {
        for (WebElement product : productTitleList) {
            if (product.getText().equals(productName)) {
                CustomListeners.node.log(Status.PASS, "Click on product '" + productName + "' : " + product.getText());
                Reporter.log("Click on product '" + productName + "' : " + product.getText() + "<br>");
                clickOnElement(product);
                break;
            }
        }
    }

}
