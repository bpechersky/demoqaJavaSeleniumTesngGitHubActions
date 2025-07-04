package com.demoqa.pages;

import org.openqa.selenium.*;
import java.io.File;

public class PracticeFormPage {

    private WebDriver driver;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");
    private By genderMale = By.xpath("//label[text()='Male']");
    private By mobile = By.id("userNumber");
    private By dateOfBirth = By.id("dateOfBirthInput");
    private By subjects = By.id("subjectsInput");
    private By hobbiesSports = By.xpath("//label[text()='Sports']");
    private By hobbiesReading = By.xpath("//label[text()='Reading']");
    private By hobbiesMusic = By.xpath("//label[text()='Music']");
    private By uploadPicture = By.id("uploadPicture");
    private By address = By.id("currentAddress");
    private By state = By.id("react-select-3-input");
    private By city = By.id("react-select-4-input");
    private By submitButton = By.id("submit");

    public void openPage() {
        driver.get("https://demoqa.com/automation-practice-form");
    }

    public void fillBasicInfo(String fname, String lname, String emailVal, String phone) {
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(email).sendKeys(emailVal);
        driver.findElement(genderMale).click();
        driver.findElement(mobile).sendKeys(phone);
    }

    public void setDateOfBirth(String dateText) {
        WebElement dateField = driver.findElement(dateOfBirth);
        dateField.sendKeys(Keys.CONTROL + "a");
        dateField.sendKeys(dateText);
        dateField.sendKeys(Keys.ENTER);
    }

    public void setSubjects(String subjectText) {
        WebElement subjectField = driver.findElement(subjects);
        subjectField.sendKeys(subjectText);
        subjectField.sendKeys(Keys.ENTER);
    }

    public void selectHobbies() {
        // Remove ad that may overlap checkbox
        ((JavascriptExecutor) driver).executeScript(
                "document.getElementById('fixedban')?.remove();" +
                        "document.getElementById('adplus-anchor')?.remove();"
        );

        WebElement checkbox = driver.findElement(By.xpath("//label[text()='Sports']"));

        // Scroll into view to ensure visibility
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);

        // Short pause to allow page to stabilize
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Now click the checkbox
        checkbox.click();
    }


    public void uploadPictureFile(String filePath) {
        driver.findElement(uploadPicture).sendKeys(new File(filePath).getAbsolutePath());
    }

    public void enterAddress(String addr) {
        driver.findElement(address).sendKeys(addr);
    }

    public void selectStateAndCity(String stateName, String cityName) {
        WebElement stateField = driver.findElement(state);
        stateField.sendKeys(stateName);
        stateField.sendKeys(Keys.ENTER);
        WebElement cityField = driver.findElement(city);
        cityField.sendKeys(cityName);
        cityField.sendKeys(Keys.ENTER);
    }

    public void clickSubmit() {
        WebElement submitBtn = driver.findElement(submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        submitBtn.click();
    }
}
