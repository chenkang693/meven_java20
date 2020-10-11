package com.ck.v3.cases;

import com.ck.v3.common.BaseCase;
import com.ck.v3.common.Constants;
import com.ck.v3.pojo.BackstageIndexPage;
import com.ck.v3.pojo.BackstageLoginPage;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddLoanCase extends BaseCase {

    public static String title = "testCk" + System.currentTimeMillis() / 1000;

    @BeforeClass
    public void setUp() throws InterruptedException {

        driver = getWebDriver(Constants.BROWER_TYPE);
        driver.get(Constants.BACKSTAGE_LOGIN_URL);
        //网页最大化
        driver.manage().window().maximize();
        //登录后台账户
        BackstageLoginPage backstageLoginPage = new BackstageLoginPage(driver);
        backstageLoginPage.inputAdminName(Constants.ADMIN_USERNAME);
        backstageLoginPage.inputAdminpwd(Constants.ADMIN_PASSWORD);
        backstageLoginPage.inputCode();
        backstageLoginPage.clickLoginBtn();
    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        close(driver);
    }
    @Test
    public void test() throws Exception {
        BackstageIndexPage backstageIndexPage = new BackstageIndexPage(driver);
        //点击
        backstageIndexPage.clickLoadAmdin();
        backstageIndexPage.clickAddLoan();
        backstageIndexPage.inputoaner("13323234444");
        //输入标题
        backstageIndexPage.inputloanTitle(title);
        //输入年利率
        backstageIndexPage.inputLoanRate("12");
        //借款期限
        backstageIndexPage.inputLoanTerm("36");
        //借款额度
        backstageIndexPage.inputAmount("1000000");
        //竞标期限
        backstageIndexPage.inputBiddingDays("15");
        Thread.sleep(1000);
        //点击风控评测
        backstageIndexPage.clickEvaluation();
        //输入评估价值
        backstageIndexPage.inputEvaluAmount("200000");
        Thread.sleep(1000);
        //点击项目录入
        backstageIndexPage.clickProjectEntry();
        //录入籍贯、职业、年龄
        backstageIndexPage.inputNative("广东");
        backstageIndexPage.inputProfession("上市老总");
        Thread.sleep(1000);
        backstageIndexPage.inputAge("35");
        //点击提交
        backstageIndexPage.clickSubmitBtn();
        //一次审核
        backstageIndexPage.clickNewLoan(title);
        backstageIndexPage.clickReviewBtn();
        backstageIndexPage.clickReviewToPassBtn();
        //二次审核
        backstageIndexPage.clickNewLoan(title);
        backstageIndexPage.clickReviewBtn();
        backstageIndexPage.clickReviewToPassBtn();
        //三次审核
        backstageIndexPage.clickNewLoan(title);
        backstageIndexPage.clickReviewBtn();
        backstageIndexPage.clickReviewToPassBtn();
    }
}
