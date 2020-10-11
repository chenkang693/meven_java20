package com.ck.v3.listeners;

import com.ck.v3.common.BaseCase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;


public class ScreenShotListener implements IHookable {
    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        Throwable throwable = testResult.getThrowable();
        if (throwable != null){
            Object obj = testResult.getInstance();
            BaseCase baseCase = (BaseCase) obj;
            String testClass = testResult.getTestClass().toString();
            System.out.println("testClass：" + testClass);
            String method = testResult.getMethod().getMethodName();
            String instanceName = testResult.getInstanceName();
            String fileName = instanceName+"_"+method+"_"+System.currentTimeMillis()+".png";
            File destFile = new File("src/test/resources/" + fileName);
            TakesScreenshot screenshot = (TakesScreenshot) baseCase.driver;
            File file = screenshot.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.moveFile(file,destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
