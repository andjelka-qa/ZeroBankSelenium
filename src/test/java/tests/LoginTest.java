package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;

    @Test
    public void testLoginWithErrorBypass() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        homePage.clickSignIn();
        loginPage.enterUsername("username");
        loginPage.enterPassword("password");
        loginPage.clickSignIn();

        driver.navigate().back();

        Thread.sleep(2000);

        Assert.assertTrue(homePage.isSettingsVisible(), "Login failed or Settings tab not found");
    }
}
