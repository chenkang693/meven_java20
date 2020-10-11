package com.ck.v1;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class LoginTest {
    public WebDriver driver = null;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources//chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("http://120.78.128.25:8765/");
        driver.findElement(By.xpath("//a[text()='登录']")).click();
        driver.findElement(By.name("phone")).sendKeys("15929550198");
        driver.findElement(By.name("password")).sendKeys("123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='登录']")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        WebElement until = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("layui-layer-content")));
        String actualValue = until.getText();
        String expectValue = "用户未注册";
        Assert.assertEquals(actualValue,expectValue);
        
    }
    @AfterClass
    public void clean() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
