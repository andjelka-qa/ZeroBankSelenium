package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.FindTransactionsPage;

import java.util.List;

public class TransactionFilterTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private FindTransactionsPage findTransactionsPage;

    @Test
    public void verifyTransactionsFilteredByDateRange() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        findTransactionsPage = new FindTransactionsPage(driver);

        homePage.clickSignIn();
        loginPage.enterUsername("username");
        loginPage.enterPassword("password");
        loginPage.clickSignIn();

        driver.navigate().back();
        Thread.sleep(5000);

        findTransactionsPage.openFindTransactions();
        Thread.sleep(3000);

        findTransactionsPage.setDateRange("2011-01-01", "2024-01-01");
        findTransactionsPage.clickFind();

        List<WebElement> dates = findTransactionsPage.getTransactionDates();
        for (WebElement dateElement : dates) {
            String dateText = dateElement.getText();
            Assert.assertTrue(
                    dateText.compareTo("2011-01-01") >= 0 && dateText.compareTo("2024-01-01") <= 0,
                    "Transaction date out of range: " + dateText
            );
        }
    }
}
