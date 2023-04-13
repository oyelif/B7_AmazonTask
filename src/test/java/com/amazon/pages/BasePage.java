package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement helloUsername;
    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signInBtn;
    @FindBy(id = "nav-link-accountList")
    public WebElement accountList;
    @FindBy(xpath = "//spam[text()='Create a List']/..")
    public WebElement create_a_List;
    @FindBy(id = "searchDropdownBox")
    public WebElement searchDropdownBox;
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;
    @FindBy(id = "nav-search-submit-button")
    public WebElement searchSubmitBtn;


    public void getLoginPage() {
        BrowserUtils.hover(helloUsername);
        signInBtn.click();
    }

    public void verifyLogin() {
        Assert.assertTrue(helloUsername.getText().contains(ConfigurationReader.get("username")));
    }

    public void selectByVisibleTextFromDropDown(WebElement element, String menu) {
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(menu);
    }

    public void selectCategoryForSearch(String category) {
        //Select dropDown=new Select(searchDropDownBox);
        //dropDown.selectByVisibleText(category);
        //BrowserUtils.waitForVisibility(searchDropdownBox,10);
        BrowserUtils.waitFor(5);
        selectByVisibleTextFromDropDown(searchDropdownBox, category);

    }

    public void verifySelectedCategory(String category) {
        Select dropDown = new Select(searchDropdownBox);
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), category);

    }

    public void searchProduct(String product) {
        searchBox.sendKeys(product);
        searchSubmitBtn.click();
    }

}


