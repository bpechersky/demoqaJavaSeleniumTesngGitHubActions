package com.demoqa.tests;

import com.demoqa.BaseTest;
import com.demoqa.pages.InteractionsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InteractionsTest extends BaseTest {

    @Test
    public void testDragAndDrop() {
        WebDriver driver = getDriver();
        InteractionsPage page = new InteractionsPage(driver);
        page.openPage();
        page.clickDroppableTab();

        Actions actions = new Actions(driver);
        actions.dragAndDrop(page.getDraggable(), page.getDroppable()).perform();

        String textAfterDrop = page.getDroppable().getText();
        Assert.assertEquals(textAfterDrop, "Dropped!", "Drag and Drop failed.");
    }
}
