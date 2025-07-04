package com.demoqa.tests;

import com.demoqa.BaseTest;
import com.demoqa.pages.TextBoxPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextBoxTest extends BaseTest {

    @Test
    public void testTextBoxFormSubmission() {
        TextBoxPage page = new TextBoxPage(driver);
        page.openPage();
        page.enterFullName("John Doe");
        page.enterEmail("john@example.com");
        page.enterCurrentAddress("123 Main St");
        page.enterPermanentAddress("456 Oak Ave");
        page.clickSubmit();
//
        assertTrue(page.getOutputName().contains("John Doe"));
        assertTrue(page.getOutputEmail().contains("john@example.com"));
    }
}
