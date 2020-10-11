package com.ck.v3.common;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class ScreenShotUtil{
    public static  void screenShot(WebDriver driver,String fileName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File f = screenshot.getScreenshotAs(OutputType.FILE);
        File desFile = new File("src/test/resources/"+fileName);
        FileUtils.moveFile(f,desFile);
        driver.quit();
    }
}
