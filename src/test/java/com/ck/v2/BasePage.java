package com.ck.v2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement waitElementVisibility(By by) {
        WebElement element = null;
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,5);
            element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (Exception e){
            System.out.println("元素定位异常：" + e.getMessage());
        }
        return element;
    }
}
