package tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class EcommerceTest extends BaseTest {
    LoginPage loginPage;
  
@BeforeMethod
    public void launchApplication() throws IOException {
        setup();
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void validLoginTest() {
        homePage = loginPage.login(
            prop.getProperty("username"),
            prop.getProperty("password")
        );

        Assert.assertTrue(
            driver.getCurrentUrl().contains("home"),
            "Epic sadface: Username and password do not match any user in this service"
        );
    }

    @Test(priority = 2)
    public void invalidLoginTest() {
        loginPage.invalidLogin(
            prop.getProperty("invalidUsername"),
            prop.getProperty("invalidPassword")
        );

        String error = loginPage.getErrorMessage();

        Assert.assertTrue(
            error.contains("Invalid"),
            "Invalid login error message not displayed"
        );
      loginPage.logout();
   
    }

   @AfterMethod
    public void closeBrowser() {
        tearDown();
    }
}
