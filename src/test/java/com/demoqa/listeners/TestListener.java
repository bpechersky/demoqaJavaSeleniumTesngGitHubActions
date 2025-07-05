package com.demoqa.listeners;

import com.demoqa.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object instance = result.getInstance();

        if (instance instanceof BaseTest) {
            WebDriver driver = ((BaseTest) instance).getDriver();

            if (driver != null) {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String path = "screenshots/" + result.getName() + ".png";
                try {
                    Files.createDirectories(Paths.get("screenshots"));
                    Files.copy(screenshot.toPath(), Paths.get(path));
                    System.out.println("Screenshot saved at: " + path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
