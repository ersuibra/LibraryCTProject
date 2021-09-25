package com.libraryCT.utillity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    //we make it abstract so it stays parent/Super class
    protected WebDriver driver;

    @BeforeEach
    public void setupWebDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterEach
    public void tearDownDriver(){
        driver.close();
    }
}
