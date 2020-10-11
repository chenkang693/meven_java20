package com.ck.v3.pojo;

import com.ck.v3.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoanDetailPage extends BasePage {
    //
    private By investAmountBy = By.xpath("//input[@data-url='/Invest/invest']");
    private By investBtnBy = By.xpath("//button[text()='投标']");
    //投标成功提示框
    private By investSuccessBy = By.xpath("//div[@class='layui-layer-content']//div[text()='投标成功！']");
    public LoanDetailPage(WebDriver driver) {
        super(driver);
    }
    //输入投资金额
    public void inputInvestAmount(String amount){
        input(investAmountBy,amount);
    }
    //点击投标
    public void clickInvestBtn(){
        click(investBtnBy);
    }
    //判断提示框是否可见
    public boolean investSuccessVisibility(){
        return elementIsDisplayed(investSuccessBy);
    }
    //获取账户金额
    public String getAccountMoney(){
        return  getAttribute(investAmountBy,"data-amount");
    }
    //获取项目剩余金额
    public String getLoanSurplusMoney(){
        return getAttribute(investAmountBy,"data-left");
    }
}
