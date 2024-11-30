package com.example.work.task.account.page.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    public String PAGE_URL;
    private final WebDriver driver;
    // If we don't want a centralized approach we can init it in each method
    private final WebDriverWait wait;

    public ProfilePage(WebDriver driver, String profileUrl) {
        this.PAGE_URL = profileUrl;
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isUrlLoaded() {
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }

    public void navigateTo() {
        this.driver.get(PAGE_URL);
    }
}
