package com.libraryCT.userStory7FilterBook;

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
        Given user is on the homePage
        When user click Books module
        And user click book category dropdown
        Then verify there are 21 options
 */
public class AllCategories extends TestBase {
    @Test
    public void filterBookCategoriesTest() {
        String[] userNames = {"librarian46@library", "librarian13@library", "student30@library", "student31@library", "student32@library"};
        ArrayList<String> userNamesList = new ArrayList<>(Arrays.asList(userNames));
        for (String eachUserName : userNamesList) {

            driver.get("https://library2.cybertekschool.com/login.html");
            WebElement emailBox = driver.findElement(By.id("inputEmail"));
            emailBox.sendKeys(eachUserName);
            WebElement passwordBox = driver.findElement(By.id("inputPassword"));
            passwordBox.sendKeys("Sdet2022*");
            passwordBox.submit();
            driver.findElement(By.xpath("//span[.='Books']")).click();
            BrowserUtility.waitFor(1);

            List<WebElement> actualListOfDropdown = driver.findElements(By.xpath("//select[@id='book_categories']/option"));
            System.out.println("actualListOfDropdown.size() = " + actualListOfDropdown.size());
            assertEquals(21, actualListOfDropdown.size());
            driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
            driver.findElement(By.xpath("//a[@class='dropdown-item']")).click();
        }

        /*
                String[] expectedModules= {"null","Action and Adventure","Anthology","Classic","Comic and Graphic Novel","Crime and Detective","Drama","Fable","Fairy Tale",
                "Fan-Fiction","Fantasy","Historical Fiction","Horror","Science Fiction","Biography/Autobiography","Humor","Romance","Short Story","Essay","Memoir","Poetry"};
        ArrayList<String> expectedListOfDropdown = new ArrayList<>(Arrays.asList( expectedModules));
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
}
