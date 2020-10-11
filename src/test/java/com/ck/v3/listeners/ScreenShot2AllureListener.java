package com.ck.v3.listeners;

import com.ck.v3.common.BaseCase;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * 截屏到allure报表中
 */
public class ScreenShot2AllureListener implements IHookable {

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        //回调测试方法，
        callBack.runTestMethod(testResult);
        //获取执行异常
        Throwable throwable = testResult.getThrowable();
        if (throwable != null){
            Object obj = testResult.getInstance();
            BaseCase baseCase = (BaseCase) obj;
            TakesScreenshot screenShot = (TakesScreenshot) baseCase.driver;
            //获取截图字节数组对象，
            byte[] screenshotBytes = screenShot.getScreenshotAs(OutputType.BYTES);
            //将字节数组传入allure收集方法中
            saveScreenshot(screenshotBytes);
        }
    }
}
