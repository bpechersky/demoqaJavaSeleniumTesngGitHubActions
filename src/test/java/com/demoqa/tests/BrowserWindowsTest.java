package com.demoqa.tests;

import com.demoqa.BaseTest;
import com.demoqa.pages.BrowserWindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserWindowsTest extends BaseTest {

    @Test
    public void testNewTabOpensCorrectly() throws InterruptedException {
        BrowserWindowsPage page = new BrowserWindowsPage(driver);
        page.openPage();

        String originalHandle = page.getCurrentWindowHandle();
        page.clickNewTab();

        Thread.sleep(1000); // Wait briefly for the new tab to open

        page.switchToNewWindow(originalHandle);

        String text = page.getNewTabOrWindowText();
        Assert.assertEquals(text.trim(), "This is a sample page");

        driver.close(); // Close new tab
        driver.switchTo().window(originalHandle);
    }

    @Test
    public void testNewWindowOpensCorrectly() throws InterruptedException {
        BrowserWindowsPage page = new BrowserWindowsPage(driver);
        page.openPage();

        String originalHandle = page.getCurrentWindowHandle();
        page.clickNewWindow();

        Thread.sleep(1000); // Wait briefly for the new window to open

        page.switchToNewWindow(originalHandle);

        String text = page.getNewTabOrWindowText();
        Assert.assertEquals(text.trim(), "This is a sample page");

        driver.close(); // Close new window
        driver.switchTo().window(originalHandle);
    }

}
