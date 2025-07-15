package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PayBillsPage {
    private WebDriver driver;

    private By payBillsTab = By.id("pay_bills_link");
    private By onlineBankingTab = By.id("onlineBankingMenu");
    private By payeeDropdown = By.id("sp_payee");
    private By accountDropdown = By.id("sp_account");
    private By amountField = By.id("sp_amount");
    private By dateField = By.id("sp_date");
    private By payButton = By.id("pay_saved_payees");
    private By successMessage = By.cssSelector(".alert-success");

    public PayBillsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPayBills() {
        driver.findElement(payBillsTab).click();
    }

    public void navigateToBankingTab() {
        driver.findElement(onlineBankingTab).click();
    }

    public void fillPaymentDetails(String amount, String date) {
        driver.findElement(amountField).sendKeys(amount);
        driver.findElement(dateField).sendKeys(date);
    }

    public void clickPay() {
        driver.findElement(payButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }
}