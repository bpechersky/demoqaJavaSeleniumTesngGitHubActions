package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicPropertiesPage {
    private final WebDriver driver;

    public DynamicPropertiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEnableAfterButton() {
        return driver.findElement(By.id("enableAfter"));
    }

    public WebElement getColorChangeButton() {
        return driver.findElement(By.id("colorChange"));
    }

    public WebElement getVisibleAfterButton() {
        return driver.findElement(By.id("visibleAfter"));
    }
}
