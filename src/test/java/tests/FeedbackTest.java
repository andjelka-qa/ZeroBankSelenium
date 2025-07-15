package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FeedbackPage;

public class FeedbackTest extends BaseTest {
    private FeedbackPage feedbackPage;

    @Test
    public void testSubmitFeedback() throws InterruptedException {
        feedbackPage = new FeedbackPage(driver);

        feedbackPage.navigateToFeedback();
        feedbackPage.fillForm("Andjelka Lazic", "andjelka.qa@example.com", "Suggestion for your site", "Improve login functionality.");
        feedbackPage.submitForm();

        Thread.sleep(2000);
    }
}