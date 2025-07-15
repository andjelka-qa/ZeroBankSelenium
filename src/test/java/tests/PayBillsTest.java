package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PayBillsPage;

public class PayBillsTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private PayBillsPage payBillsPage;

    @Test
    public void testPayBills() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        payBillsPage = new PayBillsPage(driver);

        homePage.clickSignIn();
        loginPage.enterUsername("username");
        loginPage.enterPassword("password");
        loginPage.clickSignIn();
        driver.navigate().back();

        Thread.sleep(4000);

        payBillsPage.navigateToBankingTab();
        payBillsPage.navigateToPayBills();
        payBillsPage.fillPaymentDetails("50", "2025-07-15");
        payBillsPage.clickPay();

        Assert.assertTrue(payBillsPage.isSuccessMessageDisplayed(), "Bill payment was not successful");
    }
}