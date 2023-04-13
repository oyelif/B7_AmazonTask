package com.amazon.test;

import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.YourListPage;
import com.amazon.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class AmazonTest extends TestBase{

    /** Amazon E2E Task
     *  go to amazon web page
     *  if there are cookies accept cookies
     *  log in with your own valid credential
     *  Verify that login is successful
     *  Create a new list from Account and List
     */
    LoginPage loginPage;
    HomePage homePage;
    YourListPage yourListPage;
    String accountListName="My Amazon List";
    String category ="Computers";
    String product="";

    @Test
    public void amazonTest1() {

        loginPage = new LoginPage();
        homePage = new HomePage();
        yourListPage=new YourListPage();


        extentLogger = report.createTest("Amazon E2E Test");
        extentLogger.info("Login with predefine credential");
        loginPage.getLanguageHover();
        BrowserUtils.waitFor(2);
        loginPage.login();
        BrowserUtils.waitFor(2);
        extentLogger.info("Verify that login is successful");
        homePage.verifyLogin();
        extentLogger.info("Create a new list from Account and List");
        yourListPage.getAccountList(accountListName);
        extentLogger.info("Select the "+category+" from the section tab next to the search box");
        yourListPage.selectCategoryForSearch(category);
        extentLogger.info("Verify that the "+category+" is selected");
        yourListPage.verifySelectedCategory(category);
        extentLogger.info("Write "+product+" to search box and click");
        homePage.searchProduct(product);
        extentLogger.info("Verify that the result contains "+product+ " items");
        homePage.verifySearchResult(product);
    }
}
