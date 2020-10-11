package com.ck.v2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    //定位手机号
    private By phoneBy = By.name("phone");
    //定位密码元素
    private By passwordBy = By.name("password");
    //定位登录Btn
    private By loginBtnBy = By.xpath("//button[text()='登录']");
    //页面中心错误提示
    private By centerErrorInfoBy = By.className("layui-layer-content");
    //form红色错误提示
    private By formErrorInfoBy = By.className("form-error-info");
    //输入手机号
    public  void inputPhone(String phone){
        WebElement element = waitElementVisibility(phoneBy);
        if (element != null){
            element.clear();
            element.sendKeys(phone);
        }

    }
    //输入密码
    public void inputPassword(String password){
        WebElement element = waitElementVisibility(passwordBy);
        if (element != null){
            element.clear();
            element.sendKeys(password);
        }

    }
    //点击登录
    public void clickLoginBtn(){
        WebElement element = waitElementVisibility(loginBtnBy);
        if (element != null){
            element.click();
        }


    }
    //获取中间错误提示文本内容
    public String getCenterErrorInfo(){
        WebElement element =  waitElementVisibility(centerErrorInfoBy);
        if (element != null){
            return waitElementVisibility(centerErrorInfoBy).getText();
        }
        return "";
    }

    //获取表单错误提示信息文本内容
    public String getformErrorInfo(){
        WebElement element = waitElementVisibility(formErrorInfoBy);
        if (element != null){
            return element.getText();
        }
        return "";
    }

}
