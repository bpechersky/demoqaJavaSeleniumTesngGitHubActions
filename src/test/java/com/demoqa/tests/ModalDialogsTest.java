package com.demoqa.tests;

import com.demoqa.BaseTest;
import com.demoqa.pages.ModalDialogsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class ModalDialogsTest extends BaseTest {

    @Test
    public void testSmallModal() {
        ModalDialogsPage page = new ModalDialogsPage(driver);
        page.openPage();

        page.clickSmallModalButton();
        assertEquals(page.getSmallModalTitle(), "Small Modal");

        page.closeSmallModal();
    }

    @Test
    public void testLargeModal() {
        WebDriver driver = getDriver();
        ModalDialogsPage page = new ModalDialogsPage(driver);
        page.openPage();

        page.clickLargeModalButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));

        String modalTitle = page.getLargeModalTitle();
        assertEquals(modalTitle, "Large Modal");

        page.closeLargeModal();
    }

}
