package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By signInButton = By.id("signin_button");
    private By settingsTab = By.id("settingsBox");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public boolean isSettingsVisible() {
        return driver.findElement(settingsTab).isDisplayed();
    }
}