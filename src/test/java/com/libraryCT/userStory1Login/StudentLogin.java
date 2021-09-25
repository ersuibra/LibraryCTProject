package com.libraryCT.userStory1Login;

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
    AC#2:
        Given student is on the loginPage
        Then verify that the URL is
        “https://library2.cybertekschool.com/login.html”
        When student enters valid email address and password
        And student click sign in button
        Then verify that there are 2 models on the page
 */
public class StudentLogin extends TestBase {
    @Test
    public void loginStudentTest() {

        String[] userNames = {"student30@library", "student31@library", "student32@library"};
        ArrayList<String> userNamesList = new ArrayList<>(Arrays.asList(userNames));
        for (String eachUserName : userNamesList) {

            driver.get("https://library2.cybertekschool.com/login.html");
            assertEquals("https://library2.cybertekschool.com/login.html", driver.getCurrentUrl());
            WebElement emailBox = driver.findElement(By.id("inputEmail"));
            emailBox.sendKeys(eachUserName);
            WebElement passwordBox = driver.findElement(By.id("inputPassword"));
            passwordBox.sendKeys("Sdet2022*");
            passwordBox.submit();
            BrowserUtility.waitFor(1);

            String[] expectedTitles = {"Books", "Borrowing Books"};
            ArrayList<String> expectedTitlesList = new ArrayList<>(Arrays.asList(expectedTitles));
            List<WebElement> dashboardList = driver.findElements(By.cssSelector("[class=title]"));
            System.out.println("dashboardList.size() = " + dashboardList.size());

            for (WebElement eachElement : dashboardList) {
                for (String eachTitle : expectedTitlesList) {
                    if (eachElement.getText().startsWith(eachTitle)) {
                        assertEquals(eachTitle, eachElement.getText());
                        break;
                    }
                }
            }
            driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
            driver.findElement(By.xpath("//a[@class='dropdown-item']")).click();
        }
    }
}
