package com.demoqa.tests;

import com.demoqa.BaseTest;
import com.demoqa.pages.ModalDialogsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModalDialogsTest extends BaseTest {

    @Test
    public void testSmallModal() {
        ModalDialogsPage page = new ModalDialogsPage(driver);
        page.openPage();

        page.clickSmallModalButton();
        Assert.assertEquals(page.getSmallModalTitle(), "Small Modal");

        page.closeSmallModal();
    }

    @Test
    public void testLargeModal() {
        ModalDialogsPage page = new ModalDialogsPage(driver);
        page.openPage();

        page.clickLargeModalButton();
        Assert.assertEquals(page.getLargeModalTitle(), "Large Modal");

        page.closeLargeModal();
    }
}
