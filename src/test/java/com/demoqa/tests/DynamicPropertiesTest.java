package com.demoqa.tests;

import com.demoqa.BaseTest;
import com.demoqa.pages.DynamicPropertiesPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class DynamicPropertiesTest extends BaseTest {

    @Test
    public void testDynamicProperties() {
        DynamicPropertiesPage page = new DynamicPropertiesPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/dynamic-properties");

        wait.until(ExpectedConditions.elementToBeClickable(page.getEnableAfterButton()));
        assertTrue(page.getEnableAfterButton().isEnabled());

        wait.until(driver -> page.getColorChangeButton().getAttribute("class").contains("text-danger"));
        assertTrue(page.getColorChangeButton().getAttribute("class").contains("text-danger"));

        wait.until(ExpectedConditions.visibilityOf(page.getVisibleAfterButton()));
        assertTrue(page.getVisibleAfterButton().isDisplayed());
    }
}
