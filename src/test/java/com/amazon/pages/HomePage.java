package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {




    @FindBy(xpath = "//span[contains(text(),'results for')/..")
    public WebElement resultOfSearchProduct;



    public void verifySearchResult(String product) {
        Assert.assertTrue(resultOfSearchProduct.getText().contains(product));
    }



}
