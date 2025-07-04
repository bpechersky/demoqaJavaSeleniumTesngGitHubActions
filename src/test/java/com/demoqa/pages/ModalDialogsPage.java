package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModalDialogsPage {
    private final WebDriver driver;

    private final By smallModalBtn = By.id("showSmallModal");
    private final By largeModalBtn = By.id("showLargeModal");
    private final By smallModalTitle = By.id("example-modal-sizes-title-sm");
    private final By largeModalTitle = By.id("example-modal-sizes-title-lg");
    private final By closeSmallModalBtn = By.id("closeSmallModal");
    private final By closeLargeModalBtn = By.id("closeLargeModal");

    public ModalDialogsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://demoqa.com/modal-dialogs");
    }

    public void clickSmallModalButton() {
        driver.findElement(smallModalBtn).click();
    }

    public void clickLargeModalButton() {
        driver.findElement(largeModalBtn).click();
    }

    public String getSmallModalTitle() {
        return driver.findElement(smallModalTitle).getText();
    }

    public String getLargeModalTitle() {
        return driver.findElement(largeModalTitle).getText();
    }

    public void closeSmallModal() {
        driver.findElement(closeSmallModalBtn).click();
    }

    public void closeLargeModal() {
        driver.findElement(closeLargeModalBtn).click();
    }
}
