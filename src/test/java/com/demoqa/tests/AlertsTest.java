package com.demoqa.tests;

import com.demoqa.BaseTest;
import com.demoqa.pages.AlertsPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class AlertsTest extends BaseTest {

    @Test
    public void testImmediateAlert() {
        WebDriver driver = getDriver();
        AlertsPage page = new AlertsPage(driver);
        page.openPage();

        page.clickAlertButton();

        Alert alert = page.switchToAlert();
        assertTrue(alert.getText().contains("You clicked a button"));
        alert.accept();
    }

    @Test
    public void testDelayedAlert() {
        WebDriver driver = getDriver();
        AlertsPage page = new AlertsPage(driver);
        page.openPage();

        page.clickTimerAlertButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = page.switchToAlert();
        assertTrue(alert.getText().contains("This alert appeared after 5 seconds"));
        alert.accept();
    }

    @Test
    public void testConfirmAlert() {
        WebDriver driver = getDriver();
        AlertsPage page = new AlertsPage(driver);
        page.openPage();

        page.clickConfirmButton();
        page.switchToAlert().dismiss(); // Or accept()

        assertTrue(page.getConfirmResultText().contains("Cancel"));
    }

    @Test
    public void testPromptAlert() {
        WebDriver driver = getDriver();
        AlertsPage page = new AlertsPage(driver);
        page.openPage();

        page.clickPromptButton();
        Alert alert = page.switchToAlert();
        alert.sendKeys("Test User");
        alert.accept();

        assertTrue(page.getPromptResultText().contains("Test User"));
    }
}
