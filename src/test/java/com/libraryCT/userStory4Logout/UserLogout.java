package com.libraryCT.userStory4Logout;

import com.libraryCT.utillity.BrowserUtility;
import com.libraryCT.utillity.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


/*
    AC #1:
        Given user is on the homePage
        When user click username on the right top corner
        And user click Log Out
        Then verify user navigate back to login page.
 */
public class UserLogout extends TestBase {
    @Test
    public void logoutTest() {
        String[] userNames = {"librarian46@library", "librarian13@library", "student30@library", "student31@library", "student32@library"};
        ArrayList<String> userNamesList = new ArrayList<>(Arrays.asList(userNames));
        for (String eachUserName : userNamesList) {
            driver.get("https://library2.cybertekschool.com/login.html");
            WebElement emailBox = driver.findElement(By.id("inputEmail"));
            emailBox.sendKeys(eachUserName);
            WebElement passwordBox = driver.findElement(By.id("inputPassword"));
            passwordBox.sendKeys("Sdet2022*");
            passwordBox.submit();
            BrowserUtility.waitFor(1);

            driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
            driver.findElement(By.xpath("//a[@class='dropdown-item']")).click();
            assertEquals("https://library2.cybertekschool.com/login.html", driver.getCurrentUrl());
            assertEquals("Login - Library", driver.getTitle());
        }

    }
}
