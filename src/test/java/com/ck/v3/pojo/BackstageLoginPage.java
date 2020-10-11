package com.ck.v3.pojo;


import com.ck.v3.common.BasePage;
import com.ck.v3.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BackstageLoginPage extends BasePage {
    //账户输入框
    private By adminNameBy = By.name("admin_name");
    //密码输入框
    private By adminpwdBy = By.name("admin_pwd");
    //验证码输入框
    private By codeBy = By.name("code");
    //登录按钮
    private By loginBtnBy = By.xpath("//button[text()='登陆后台']");

    public BackstageLoginPage(WebDriver driver) {
        super(driver);
    }

    //输入账户
    public void inputAdminName(String adminName){
        input(adminNameBy,adminName);
    }
    //输入密码
    public void inputAdminpwd(String adminpwd){
        input(adminpwdBy,adminpwd);
    }
    //输入验证吗
    public void inputCode(){
        input(codeBy, Constants.CODE);
    }
    //点击登录
    public void clickLoginBtn(){
        click(loginBtnBy);
    }
}
