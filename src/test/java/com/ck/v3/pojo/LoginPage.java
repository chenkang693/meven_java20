package com.ck.v3.pojo;

import com.ck.v3.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
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
    //记住手机号
    private By rememberMeBy = By.name("remember_me");
    //获取手机号文本
    public String getPhone(){
       return getAttribute(phoneBy,"value");
    }
    //勾选记住手机号
    public void  clickRememberMe(){
        String attr = getAttribute(rememberMeBy, "checked");
        if (!"true".equals(attr)){
            click(rememberMeBy);
        }

    }
    //输入手机号
    public  void inputPhone(String phone){
        input(phoneBy,phone);

    }
    //输入密码
    public void inputPassword(String password){
        input(passwordBy,password);

    }
    //点击登录
    public void clickLoginBtn(){
        click(loginBtnBy);
    }
    //获取中间错误提示文本内容
    public String getCenterErrorInfo(){
       return getElementText(centerErrorInfoBy);
    }

    //获取表单错误提示信息文本内容
    public String getformErrorInfo(){
        return getElementText(formErrorInfoBy);
    }

}
