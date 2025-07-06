package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InteractionsPage {
    private final WebDriver driver;

    private final By sortableTab = By.xpath("//span[text()='Sortable']");
    private final By droppableTab = By.xpath("//span[text()='Droppable']");
    private final By draggable = By.id("draggable");
    private final By droppable = By.id("droppable");

    public InteractionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://demoqa.com/interaction");
    }

    public void clickDroppableTab() {
        driver.findElement(droppableTab).click();
    }

    public WebElement getDraggable() {
        return driver.findElement(draggable);
    }

    public WebElement getDroppable() {
        return driver.findElement(droppable);
    }
}
