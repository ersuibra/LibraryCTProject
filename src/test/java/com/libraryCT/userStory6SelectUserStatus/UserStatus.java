package com.libraryCT.userStory6SelectUserStatus;

import com.libraryCT.utillity.BrowserUtility;
import com.libraryCT.utillity.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    AC #1:
        Given librarian is on the homePage
        When librarian click Users module
        And librarian click Status dropdown
        Then verify there are 2 status options
 */

public class UserStatus extends TestBase {
    @Test
    public void selectUserGroupsTest() {
        String[] userNames = {"librarian46@library", "librarian13@library"};
        ArrayList<String> userNamesList = new ArrayList<>(Arrays.asList(userNames));
        for (String eachUserName : userNamesList) {
            driver.get("https://library2.cybertekschool.com/login.html");
            WebElement emailBox = driver.findElement(By.id("inputEmail"));
            emailBox.sendKeys(eachUserName);
            WebElement passwordBox = driver.findElement(By.id("inputPassword"));
            passwordBox.sendKeys("Sdet2022*");
            passwordBox.submit();
            driver.findElement(By.xpath("//span[.='Users']")).click();

            BrowserUtility.waitFor(1);

            List<WebElement> actualListOfDropdown = driver.findElements(By.xpath("//select[@id='user_status']/option"));
            System.out.println("actualListOfDropdown.size() = " + actualListOfDropdown.size());
            assertEquals(2, actualListOfDropdown.size());

            driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
            driver.findElement(By.xpath("//a[@class='dropdown-item']")).click();
        }
    }
    /*
            String[] expectedModules = {"ACTIVE", "INACTIVE"};
            ArrayList<String> expectedListOfDropdown = new ArrayList<>(Arrays.asList(expectedModules));
            for (WebElement eachElement : actualListOfDropdown) {
                for (String eachTitle : expectedListOfDropdown) {
                    if (eachElement.getText().equals(eachTitle)) {
                        assertEquals(eachTitle, eachElement.getText());
                        break;
                    }
                }
            }
     */
}
