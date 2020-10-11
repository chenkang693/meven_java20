package com.ck.v3.pojo;

import com.ck.v3.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BackstageIndexPage extends BasePage {
    //借款管理
    private By loadAmdinBy = By.xpath("//span[text()='借款管理']");
    //mainIframe
    private By mainIframeBy = By.id("mainFrame");
    //加标
    private By addLoanByBtn = By.id("add");
    //借款人
    private By loanerBy = By.xpath(" //input[@placeholder='输入手机号码进行查找']");
    //贷款标题
    private By loanTitleBy = By.xpath("//td[text()='贷款标题:']//following-sibling::td//input");
    //年利率利息
    private By loanRateBy = By.name("LoanRate");
    //借款期限
    private By loanTermBy = By.xpath("//td[text()='借款期限:']//following-sibling::td//input");
    //借款额度:
    private By amountBy = By.xpath("//td[text()='借款额度:']//following-sibling::td//input");

    //竞标期限:
    private By biddingDaysBy = By.xpath("//td[text()='竞标期限:']//following-sibling::td//input");
    //风控评测
    private By evaluationBy = By.xpath("//span[text()='风控评测']");
    //评估价值:
    private By evaluAmountBy = By.xpath("//td[text()='评估价值:']//following-sibling::td//input");
    //项目录入
    private By projectEntryBy = By.xpath("//span[text()='项目录入']");
    //籍贯:Native
    private By nativeBy = By.xpath("//td[text()='籍贯:']//following-sibling::td//input");
    //职业
    private By professionBy = By.xpath("//td[text()='职业:']//following-sibling::td//input");
    //年龄
    private By ageBy = By.xpath("//td[text()='年龄:']//following-sibling::td//input");

    //提交按钮
    private By submitBtnBY = By.id("add_do");
    //审核按钮
    private By reviewBtnBy = By.xpath("//span[text()='审核']");
    //审核通过按钮
    private By reviewToPassBtnBy = By.xpath("//span[text()='审核通过']");
    public BackstageIndexPage(WebDriver driver) {
        super(driver);
    }
    public void clickLoadAmdin(){
        click(loadAmdinBy);
    }
    public void clickAddLoan(){
        WebElement iframe = waitElementClickable(mainIframeBy);
        driver.switchTo().frame(iframe);
        click(addLoanByBtn);
    }

    public void inputoaner(String loanPhone){

        try {
            input(loanerBy,loanPhone);
            Thread.sleep(2000);
            inputKeys(loanerBy, Keys.ARROW_DOWN);

            inputKeys(loanerBy,Keys.ENTER);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("元素定位异常：" + e.getMessage());
        }

    }

    public void inputloanTitle(String loanTitle) {
        input(loanTitleBy, loanTitle);
    }

    //年利率利息
    public void inputLoanRate(String loanRate) {
        input(loanRateBy, loanRate);
    }

    //借款期限
    public void inputLoanTerm(String loanTerm) {
        input(loanTermBy, loanTerm);
    }

    //借款额度:
    public void inputAmount(String amount) {
        input(amountBy, amount);
    }

    //竞标期限:
    public void inputBiddingDays(String biddingDays) {
        input(biddingDaysBy, biddingDays);
    }

    //风控评测
    public void clickEvaluation() {
        click(evaluationBy);
    }

    //评估价值:
    public void inputEvaluAmount(String evaluAmount) {
        input(evaluAmountBy, evaluAmount);
    }

    //项目录入
    public void clickProjectEntry() {
        click(projectEntryBy);
    }

    //籍贯:Native
    public void inputNative(String nativestr) {
        input(nativeBy, nativestr);
    }

    //职业
    public void inputProfession(String profession) {
        input(professionBy, profession);
    }

    //年龄
    public void inputAge(String age) {
        input(ageBy, age);
    }
    //点击提交
    public void clickSubmitBtn(){
        click(submitBtnBY);
    }


    /**
     * 选中title信息
     * @param title
     */
    public void clickNewLoan(String title){
        try {
            Thread.sleep(1000);
            By by = By.xpath("//div[text()='"+title+"']//parent::td//parent::tr");
            click(by);
        } catch (InterruptedException e) {
            System.out.println("异常"+ e.getMessage());
        }

    }
    //点击审核
    public void clickReviewBtn(){
        click(reviewBtnBy);
    }
    //点击审核通过
    public void clickReviewToPassBtn(){
        click(reviewToPassBtnBy);
    }
}
