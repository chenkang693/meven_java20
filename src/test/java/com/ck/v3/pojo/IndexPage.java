package com.ck.v3.pojo;

import com.ck.v3.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver){
        super(driver);
    }

    private By nickNameBy = By.xpath("//*[contains(text(),'自动化测试帐号1')]");
    //退出元素
    private By logoutBy = By.xpath("//a[text()='退出']");
    //登录元素
    private By loginBy = By.xpath("//a[text()='登录']");
    //抢投标//span[text()=' 借款ck1600144993']//parent::div//parent::a//following-sibling::div//a
    //点击登录
    public void clickLogin(){
        click(loginBy);
    }
    //点击退出
    public void clickLogout(){
       click(logoutBy);
    }
    public boolean nickNamevisibility(){
        return elementIsDisplayed(nickNameBy);
    }
    //点击抢投标
    public void clickInvestBtn(String loanTitle){
        By by = By.xpath("//span[text()=' " + loanTitle + "']//parent::div//parent::a//following-sibling::div//a");
        click(by);
    }

}
