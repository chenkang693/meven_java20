package com.ck.v2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage extends BasePage{
    private WebDriver driver;
    public IndexPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By nickNameBy = By.xpath("//*[contains(text(),'自动化测试帐号1')]");

    public boolean nickNamevisibility(){
        WebElement element = waitElementVisibility(nickNameBy);
        if (element != null){
            return element.isDisplayed();
        }
        return false;
    }

}
