package com.libraryCT.userStory1Login;

import com.libraryCT.utillity.BrowserUtility;
import com.libraryCT.utillity.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/*
    AC #3 [negative]:
        Given user is on the loginPage
        When user enters invalid email address or password
        And student click sign in button
        Then verify the error message “Sorry, Wrong Email or Password”

 */
public class UserLogin extends TestBase {
    @Test
    public void loginStudentTest() {
        String[] userNames = {"librarian465@library", "librarian135@library", "student305@library", "student315@library", "student325@library"};
        ArrayList<String> userNamesList = new ArrayList<>(Arrays.asList(userNames));
        for (String eachUserName : userNamesList) {

            driver.get("https://library2.cybertekschool.com/login.html");
            WebElement emailBox = driver.findElement(By.id("inputEmail"));
            emailBox.sendKeys(eachUserName);
            WebElement passwordBox = driver.findElement(By.id("inputPassword"));
            passwordBox.sendKeys("Sdet2022*");
            passwordBox.submit();
            WebElement warningMessage = driver.findElement(By.cssSelector("[class='alert alert-danger']"));
            BrowserUtility.waitFor(1);
            assertEquals("Sorry, Wrong Email or Password", warningMessage.getText());
        }

    }

}
