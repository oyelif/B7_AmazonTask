package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourListPage extends BasePage {

    @FindBy(id = "list-name")
    public WebElement listName;
    @FindBy(id = "wl-redesigned-create-list")
    public WebElement createListBtnPopUp;
    @FindBy(id = "wl-create-list-cancel")
    public WebElement cancelCreateListOnPopUp;

    public void getAccountList(String accountListName){
        BrowserUtils.hover(accountList);
        create_a_List.click();
        BrowserUtils.waitForClickablility(listName,10).click();
        listName.clear();
        listName.sendKeys(accountListName);
        createListBtnPopUp.click();
        //cancelCreateListOnPopUp.click();

    }
}
