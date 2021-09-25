package com.libraryCT.userStory2AddNewUser;

import com.libraryCT.utillity.BrowserUtility;
import com.libraryCT.utillity.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/*
    AC #1:
        Given librarian is on the homePage
        When librarian click Users module
        And librarian click “+Add User” button
        When librarian enter full name, password, email and
        address
        And librarian click save changes
        Then verify a new user is created
 */

public class AddNewUser extends TestBase {

    @Test
    public void addNewUserTest() {
        String[] userNames = {"librarian46@library", "librarian13@library"};
        ArrayList<String> userNamesList = new ArrayList<>(Arrays.asList(userNames));
        //Change emailNumber to avoid email duplication issue
        int emailNumber = 35;
        for (String eachUserName : userNamesList) {
            driver.get("https://library2.cybertekschool.com/login.html");
            WebElement emailBox = driver.findElement(By.id("inputEmail"));
            emailBox.sendKeys(eachUserName);
            WebElement passwordBox = driver.findElement(By.id("inputPassword"));
            passwordBox.sendKeys("Sdet2022*");
            passwordBox.submit();
            BrowserUtility.waitFor(1);

            String userEmail = "abraham_lincoln" + emailNumber++ + "@SDET.com";
            driver.findElement(By.xpath("//span[.='Users']")).click();
            driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")).click();
            driver.findElement(By.cssSelector("input[type='text'][name='full_name']")).sendKeys("Abraham Lincoln");
            driver.findElement(By.cssSelector("input[type='password'][name='password']")).sendKeys("Sdet2022*");
            driver.findElement(By.cssSelector("input[type='text'][name='email']")).sendKeys(userEmail);
            driver.findElement(By.cssSelector("textarea[id=address]")).sendKeys("Abraham Lincoln Drive, Hodgenville, LaRue County, Kentucky, USA");
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            assertTrue(driver.findElement(By.cssSelector("[class='toast-message']")).isDisplayed());
            BrowserUtility.waitFor(5);

            driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
            driver.findElement(By.xpath("//a[@class='dropdown-item']")).click();
        }
            /*
        Previously Used to Confirm New User is created with Search
        BrowserUtility.waitFor(1);
        driver.findElement(By.cssSelector("input[type='search']")).sendKeys("Abraham Lincoln");
        //To address the StaleElementReferenceException
        driver.navigate().refresh();
                    List<WebElement> usersList = driver.findElements(By.xpath("//tr/td[4]"));
            System.out.println("usersList.size() = " + usersList.size());
            for (WebElement eachElement : usersList) {
                if (eachElement.getText().equals(userEmail)) {
                    assertEquals(userEmail, eachElement.getText());
                    break;
                }
            }
         */

    }
}
