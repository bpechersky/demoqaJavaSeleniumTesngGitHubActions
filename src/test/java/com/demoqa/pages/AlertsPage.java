package com.demoqa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver driver;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://demoqa.com/alerts");
    }

    public void clickAlertButton() {
        driver.findElement(By.id("alertButton")).click();
    }

    public void clickTimerAlertButton() {
        driver.findElement(By.id("timerAlertButton")).click();
    }

    public void clickConfirmButton() {
        driver.findElement(By.id("confirmButton")).click();
    }

    public void clickPromptButton() {
        driver.findElement(By.id("promtButton")).click();
    }

    public Alert switchToAlert() {
        return driver.switchTo().alert();
    }

    public String getConfirmResultText() {
        return driver.findElement(By.id("confirmResult")).getText();
    }

    public String getPromptResultText() {
        return driver.findElement(By.id("promptResult")).getText();
    }
}
