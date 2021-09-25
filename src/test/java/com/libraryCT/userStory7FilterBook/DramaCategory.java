package com.libraryCT.userStory7FilterBook;

import com.libraryCT.utillity.BrowserUtility;
import com.libraryCT.utillity.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/*
    AC #2:
        Given user is on the homePage
        When user click Books module
        And user click book category dropdown
        Then verify user is able to selected the “Drama” option
 */
public class DramaCategory extends TestBase {
    @Test
    public void filterDramaBooksTest() {
        String[] userNames = {"librarian46@library", "librarian13@library", "student30@library", "student31@library", "student32@library"};
        ArrayList<String> userNamesList = new ArrayList<>(Arrays.asList(userNames));
        for (String eachUserName : userNamesList) {

            driver.get("https://library2.cybertekschool.com/login.html");
            WebElement emailBox = driver.findElement(By.id("inputEmail"));
            emailBox.sendKeys("librarian46@library");
            WebElement passwordBox = driver.findElement(By.id("inputPassword"));
            passwordBox.sendKeys("Sdet2022*");
            passwordBox.submit();
            driver.findElement(By.xpath("//span[.='Books']")).click();

            BrowserUtility.waitFor(1);
            assertEquals("Drama", driver.findElement(By.xpath("//select[@id='book_categories']/option[@value='6']")).getText());
            driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
            driver.findElement(By.xpath("//a[@class='dropdown-item']")).click();
        }
    }
}
