package com.ck.v3.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public Logger logger = Logger.getLogger(BasePage.class);
    public WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * 等待元素可以见
     * @param by
     * @return
     */
    public WebElement waitElementVisibility(By by) {
        logger.info(by);
        WebElement element = null;
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,5);
            element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (Exception e){
            logger.error("元素定位异常：" + e.getMessage());
        }
        return element;
    }

    /**
     * 等待元素可以点击
     * @param by
     * @return
     */
    public WebElement waitElementClickable(By by) {
        logger.info(by);
        WebElement element = null;
        try{
            WebDriverWait webDriverWait = new WebDriverWait(driver,5);
            element = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        }catch (Exception e){
            logger.error("元素定位异常：" + e.getMessage());
        }
        return element;
    }

    /**
     * 输入
     * @param by 定位元素
     * @param content 内容
     */
    public void input(By by,String content){
        WebElement element = waitElementVisibility(by);
        if (element != null){
            element.clear();
            element.sendKeys(content);
        }
    }

    /**
     * 点击
     * @param by
     */
    public void click(By by){
        WebElement element = waitElementClickable(by);
        if (element != null){
            element.click();
        }
    }

    /**
     * 获取文本
     * @param by
     * @return
     */
    public String getElementText(By by){
        WebElement element =  waitElementVisibility(by);
        if (element != null){
            return element.getText();
        }
        return "";
    }

    /**
     * 获取属性
     * @return
     */
    public String getAttribute(By by,String attrName){
        WebElement element = waitElementVisibility(by);
        if (element != null){
            String value = element.getAttribute(attrName);
            return value;
        }
        return "";
    }

    /**
     * 判断元素是否可见
     * @param by
     * @return
     */
    public boolean elementIsDisplayed(By by){
        WebElement element = waitElementVisibility(by);
        if (element != null){
            return element.isDisplayed();
        }
        return false;
    }

    /**
     * 输入键盘键位
     * @param by
     * @param key
     */
    public void inputKeys(By by, Keys key){
        WebElement element = waitElementVisibility(by);
        if (element != null){
            element.sendKeys(key);
        }

    }
}
