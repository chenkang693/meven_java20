package com.ck.v3.cases;

import com.ck.v3.common.BaseCase;
import com.ck.v3.common.Constants;
import com.ck.v3.pojo.IndexPage;
import com.ck.v3.pojo.LoanDetailPage;
import com.ck.v3.pojo.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class InvestCase extends BaseCase {

    @BeforeClass
    public void setUp(){
        driver = getWebDriver(Constants.BROWER_TYPE);
        driver.get(Constants.LOGIN_URL);
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPhone("13323234545");
        loginPage.inputPassword("lemon123456");
        loginPage.clickLoginBtn();
    }
    @Test
    public void testInvest() throws InterruptedException {
        IndexPage indexPage = new IndexPage(driver);
        String title = AddLoanCase.title;
        indexPage.clickInvestBtn(title);
        LoanDetailPage loanDetailPage = new LoanDetailPage(driver);
        String beforeAmountStr = loanDetailPage.getAccountMoney();
        String beforeLoanSurplusMoneyStr = loanDetailPage.getLoanSurplusMoney();
        String investAmountStr = "100";
        loanDetailPage.inputInvestAmount(investAmountStr);
        loanDetailPage.clickInvestBtn();
        boolean actual = loanDetailPage.investSuccessVisibility();
        Assert.assertTrue(actual);
        Thread.sleep(1000);
        //刷新页面
        driver.navigate().refresh();
        String afterAmountStr = loanDetailPage.getAccountMoney();
        String afterLoanSurplusMoneyStr = loanDetailPage.getLoanSurplusMoney();

        BigDecimal beforeAmount = new BigDecimal(beforeAmountStr);
        BigDecimal afterAmount = new BigDecimal(afterAmountStr);
        BigDecimal investAmount = new BigDecimal(investAmountStr);
        BigDecimal beforeLoanSurplusMoney = new BigDecimal(beforeLoanSurplusMoneyStr);
        BigDecimal afterLoanSurplusMoney = new BigDecimal(afterLoanSurplusMoneyStr);
        //判断账户金额
        BigDecimal subtractAmount = beforeAmount.subtract(afterAmount);
        System.out.println("subtractAmount:" + subtractAmount);
        boolean flag1 = subtractAmount.compareTo(investAmount)==0;
        //判断标的剩余金额
        BigDecimal subtractLoanSurplusMoney = beforeLoanSurplusMoney.subtract(afterLoanSurplusMoney);
        System.out.println("subtractLoanSurplusMoney:" + subtractLoanSurplusMoney);
        boolean flag2 = subtractLoanSurplusMoney.compareTo(investAmount) ==0;
        boolean flagResult = false;
        if (flag1 && flag2 && actual){
            flagResult = true;
        }
        Assert.assertTrue(flagResult);


    }
    @AfterClass
    public void tearDown(){
        close(driver);
    }
}
