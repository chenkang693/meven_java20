package com.ck.v3.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseCase {
    public Logger logger = Logger.getLogger(BaseCase.class);
    public WebDriver driver;

    public void close(WebDriver driver){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
    public  WebDriver getWebDriver(String type){
         WebDriver driver = null;
        if ("ie".equalsIgnoreCase(type)){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,"https://www.baidu.com");
            System.setProperty("webdriver.ie.driver","src/test/resources/IEDriverServer.exe");
            driver = new InternetExplorerDriver(capabilities);
        }else if ("chrome".equalsIgnoreCase(type)){
            System.setProperty("webdriver.chrome.driver","src/test/resources//chromedriver.exe");
            driver = new ChromeDriver();
        }else if ("firefox".equalsIgnoreCase(type)){
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_BINARY,"D:/tools/firefox/firefox.exe");
            System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
            driver =  new FirefoxDriver();
        }
        logger.info("加载Webdriver驱动完成");
        return driver;

    }
}
