package com.demoqa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBoxPage {

    private WebDriver driver;

    private By fullNameInput = By.id("userName");
    private By emailInput = By.id("userEmail");
    private By currentAddressInput = By.id("currentAddress");
    private By permanentAddressInput = By.id("permanentAddress");
    private By submitButton = By.id("submit");

    private By outputName = By.id("name");
    private By outputEmail = By.id("email");

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://demoqa.com/text-box");
    }

    public void enterFullName(String fullName) {
        driver.findElement(fullNameInput).sendKeys(fullName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterCurrentAddress(String currentAddress) {
        driver.findElement(currentAddressInput).sendKeys(currentAddress);
    }

    public void enterPermanentAddress(String permanentAddress) {
        driver.findElement(permanentAddressInput).sendKeys(permanentAddress);
    }

    public void clickSubmit() {
        WebElement submitBtn = driver.findElement(submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();
    }

    public String getOutputName() {
        return driver.findElement(outputName).getText();
    }

    public String getOutputEmail() {
        return driver.findElement(outputEmail).getText();
    }
}
