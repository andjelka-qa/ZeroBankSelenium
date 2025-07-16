package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindTransactionsPage {
    private WebDriver driver;

    private By accountActivityTab = By.id("account_activity_link");
    private By findTransactionsTab = By.linkText("Find Transactions");
    private By fromDateInput = By.id("aa_fromDate");
    private By toDateInput = By.id("aa_toDate");
    private By findButton = By.cssSelector("button[type='submit']");
    private By transactionDates = By.cssSelector("#filtered_transactions_for_account tbody td:nth-child(1)");

    public FindTransactionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openFindTransactions() {
        driver.findElement(accountActivityTab).click();
        driver.findElement(findTransactionsTab).click();
    }

    public void setDateRange(String from, String to) {
        driver.findElement(fromDateInput).clear();
        driver.findElement(fromDateInput).sendKeys(from);
        driver.findElement(toDateInput).clear();
        driver.findElement(toDateInput).sendKeys(to);
    }

    public void clickFind() {
        driver.findElement(findButton).click();
    }

    public List<WebElement> getTransactionDates() {
        return driver.findElements(transactionDates);
    }

}
