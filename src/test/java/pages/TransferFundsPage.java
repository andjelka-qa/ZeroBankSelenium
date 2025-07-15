package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferFundsPage {
    private WebDriver driver;

    private By transferFundsTab = By.id("transfer_funds_link");
    private By fromAccount = By.id("tf_fromAccountId");
    private By toAccount = By.id("tf_toAccountId");
    private By amountField = By.id("tf_amount");
    private By descriptionField = By.id("tf_description");
    private By continueButton = By.id("btn_submit");
    private By submitButton = By.xpath("//button[@type='submit']");
    private By successMessage = By.cssSelector(".alert-success");

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToTransferFunds() {
        driver.findElement(transferFundsTab).click();
    }

    public void fillTransferDetails(String amount, String description) {
        driver.findElement(fromAccount).click();
        driver.findElement(toAccount).click();
        driver.findElement(amountField).sendKeys(amount);
        driver.findElement(descriptionField).sendKeys(description);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }
}
