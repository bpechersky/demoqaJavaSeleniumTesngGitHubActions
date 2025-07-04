package com.demoqa.tests;

import com.demoqa.BaseTest;
import com.demoqa.pages.PracticeFormPage;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {

    @Test
    public void testCompleteFormSubmission() {
        PracticeFormPage page = new PracticeFormPage(driver);
        page.openPage();

        page.fillBasicInfo("Boris", "Pechersky", "boris@example.com", "9876543210");
        page.setDateOfBirth("10 May 1990");
        page.setSubjects("Computer Science");
        page.selectHobbies();
        page.uploadPictureFile("src/test/resources/test-picture.png"); // Make sure this file exists
        page.enterAddress("123 QA Automation Lane");
        page.selectStateAndCity("NCR", "Delhi");
        page.clickSubmit();

        // You can add validation for modal or confirmation message here
    }
}
