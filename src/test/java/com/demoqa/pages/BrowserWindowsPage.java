package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class BrowserWindowsPage {

    private final WebDriver driver;

    private final By newTabButton = By.id("tabButton");
    private final By newWindowButton = By.id("windowButton");

    public BrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://demoqa.com/browser-windows");
    }

    public void clickNewTab() {
        driver.findElement(newTabButton).click();
    }

    public void clickNewWindow() {
        driver.findElement(newWindowButton).click();
    }

    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }

    public int getTotalWindows() {
        return driver.getWindowHandles().size();
    }

    public void switchToNewWindow(String originalHandle) {
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public String getNewTabOrWindowText() {
        return driver.findElement(By.id("sampleHeading")).getText();
    }
}
