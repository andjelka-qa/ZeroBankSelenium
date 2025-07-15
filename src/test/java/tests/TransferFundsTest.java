package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.TransferFundsPage;

public class TransferFundsTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private TransferFundsPage transferFundsPage;

    @Test
    public void testTransferFunds() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        transferFundsPage = new TransferFundsPage(driver);

        homePage.clickSignIn();
        loginPage.enterUsername("username");
        loginPage.enterPassword("password");
        loginPage.clickSignIn();
        driver.navigate().back();

        Thread.sleep(2000);

        transferFundsPage.navigateToTransferFunds();
        transferFundsPage.fillTransferDetails("100", "Automated transfer");
        transferFundsPage.clickContinue();
        transferFundsPage.clickSubmit();

        Assert.assertTrue(transferFundsPage.isSuccessMessageDisplayed(), "Transfer was not successful");
    }
}
