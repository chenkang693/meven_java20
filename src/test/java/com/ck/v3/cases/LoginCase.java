package com.ck.v3.cases;

import com.ck.v3.common.BaseCase;
import com.ck.v3.listeners.MyRetry;
import com.ck.v3.pojo.IndexPage;
import com.ck.v3.pojo.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginCase extends BaseCase {
    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = getWebDriver("chrome");

    }
    @BeforeMethod
    public void beforeMethod(){
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
        String expectInfo = "此账号没有经过授权，请联系管理员!123";
        Assert.assertEquals(actualInfo,expectInfo);
    }
    @Test
    public void testFail03(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPhone("1592955019");
        loginPage.inputPassword("123");
        loginPage.clickLoginBtn();
        String actualInfo = loginPage.getformErrorInfo();
        String expectInfo = "请输入正确的手机号1";
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
    @Test(priority = 2)
    public void testSuccess() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPhone("13323234545");
        loginPage.inputPassword("lemon123456");
        loginPage.clickLoginBtn();
        IndexPage indexPage = new IndexPage(driver);
        boolean resultFlag = indexPage.nickNamevisibility();
        Assert.assertTrue(resultFlag);
    }
    @Test(priority = 1)
    public void testSuccess2(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPhone("13323234545");
        loginPage.inputPassword("lemon123456");
        loginPage.clickLoginBtn();
        IndexPage indexPage = new IndexPage(driver);
        //driver.manage().window().maximize();
        indexPage.clickLogout();
        indexPage.clickLogin();
        String actual = loginPage.getPhone();
        Assert.assertEquals(actual,"13323234545");
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
         close(driver);
    }
}
