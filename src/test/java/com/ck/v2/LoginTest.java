package com.ck.v2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    public WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://120.78.128.25:8765/Index/login.html");
    }
    @Test
    public void testFail01(){
       LoginPage loginPage = new LoginPage(driver);
       loginPage.inputPhone("15929550125");
       loginPage.inputPassword("123");
       loginPage.clickLoginBtn();
       String actualInfo = loginPage.getCenterErrorInfo();
       String expectInfo = "帐号或密码错误!";
       Assert.assertEquals(actualInfo,expectInfo);
    }
    @Test
    public void testFail02(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPhone("15929550190");
        loginPage.inputPassword("123");
        loginPage.clickLoginBtn();
        String actualInfo = loginPage.getCenterErrorInfo();
        String expectInfo = "此账号没有经过授权，请联系管理员!";
        Assert.assertEquals(actualInfo,expectInfo);
    }
    @Test
    public void testFail03(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPhone("1592955019");
        loginPage.inputPassword("123");
        loginPage.clickLoginBtn();
        String actualInfo = loginPage.getformErrorInfo();
        String expectInfo = "请输入正确的手机号";
        Assert.assertEquals(actualInfo,expectInfo);
    }
    @Test(dataProvider = "datas")
    public void testFail04(String phone,String password,String expectInfo){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPhone(phone);
        loginPage.inputPassword(password);
        loginPage.clickLoginBtn();
        String actualInfo = loginPage.getformErrorInfo();
        Assert.assertEquals(actualInfo,expectInfo);
    }
    @Test
    public void testSuccess() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPhone("13323234545");
        loginPage.inputPassword("lemon123456");
        loginPage.clickLoginBtn();
        IndexPage indexPage = new IndexPage(driver); 
        boolean resultFlag = indexPage.nickNamevisibility();
        Assert.assertTrue(resultFlag);
    }
    @DataProvider
    public Object[][] datas(){
        Object[][] datas ={
                {"","12356","请输入手机号"},
                {"1592955019","12345","请输入正确的手机号"},
                {"159295501911","123","请输入正确的手机号"}

        };
        return datas;
    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
