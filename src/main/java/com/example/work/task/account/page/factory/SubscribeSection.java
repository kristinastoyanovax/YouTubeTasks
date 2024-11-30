package com.example.work.task.account.page.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubscribeSection {
    public final WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(tagName = "yt-subscribe-button-view-model")
    private WebElement subscribeButton;
    // paper-toast provides a subtle notification toast. Appears when we sub and unsub
    @FindBy(tagName = "tp-yt-paper-toast")
    private WebElement paperToaster;


    public SubscribeSection(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isSubscribed() {
        wait.until(ExpectedConditions.visibilityOf(subscribeButton));
        // doesn't take into account localization
        return subscribeButton.getText().equals("Unsubscribe");
    }

    /**
     * Waits until the subscribe button is visible and clicks it.
     */
    public void subscribe() {
        WebElement result = wait.until(ExpectedConditions.elementToBeClickable(subscribeButton));
        // Avoid the webdriver exception below
        // try/catch can also be used
        if (result != null) {
            subscribeButton.click();
        }
    }
}
