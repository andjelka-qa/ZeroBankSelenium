package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FeedbackPage {
    private WebDriver driver;

    private By feedbackLink = By.id("feedback");
    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By subjectField = By.id("subject");
    private By commentField = By.id("comment");
    private By sendMessageButton = By.name("submit");

    public FeedbackPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToFeedback() {
        driver.findElement(feedbackLink).click();
    }

    public void fillForm(String name, String email, String subject, String comment) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(commentField).sendKeys(comment);
    }

    public void submitForm() {
        driver.findElement(sendMessageButton).click();
    }
}
