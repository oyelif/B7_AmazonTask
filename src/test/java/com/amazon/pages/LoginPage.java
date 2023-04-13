package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.ConcurrentHashMap;

public class LoginPage extends BasePage{

    @FindBy(id = "ap_email")
    public WebElement emailInput;
    @FindBy(id = "continue")
    public WebElement continueBtn;
    @FindBy(id = "ap_password")
    public WebElement passwordInput;
    @FindBy(id = "signInSubmit")
    public WebElement signInSubmitBtn;

    @FindBy(id = "icp-nav-flyout")
    public WebElement languageHover;
    @FindBy(xpath = "//span[contains(text(),'English')]")
    public WebElement EnglishBtn;


    public void getLanguageHover() {
        BrowserUtils.hover(languageHover);
        EnglishBtn.click();
    }

    public void login(){
        getLoginPage();
        emailInput.sendKeys(ConfigurationReader.get("email"));
        continueBtn.click();
        passwordInput.sendKeys(ConfigurationReader.get("password"));
        signInSubmitBtn.click();
    }
}
