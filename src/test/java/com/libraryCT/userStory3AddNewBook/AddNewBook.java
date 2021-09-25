package com.libraryCT.userStory3AddNewBook;

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
        When librarian click Books module
        And librarian click “+Add Book” button
        When librarian enter BookName, ISBN, Year, Author, and Description
        And librarian click save changes
        Then verify a new book is added
 */
public class AddNewBook extends TestBase {
    @Test
    public void addNewBookTest() {
        String[] userNames = {"librarian46@library", "librarian13@library"};
        ArrayList<String> userNamesList = new ArrayList<>(Arrays.asList(userNames));
        int bookNumber = 12;
        for (String eachUserName : userNamesList) {
            driver.get("https://library2.cybertekschool.com/login.html");
            WebElement emailBox = driver.findElement(By.id("inputEmail"));
            emailBox.sendKeys(eachUserName);
            WebElement passwordBox = driver.findElement(By.id("inputPassword"));
            passwordBox.sendKeys("Sdet2022*");
            passwordBox.submit();
            BrowserUtility.waitFor(1);

            String bookName = "Abraham Lincoln's Cake Shop "+bookNumber++;
            driver.findElement(By.xpath("//span[.='Books']")).click();
            driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']")).click();
            driver.findElement(By.cssSelector("input[name='name']")).sendKeys(bookName);
            driver.findElement(By.cssSelector("input[name='isbn']")).sendKeys("02121809");
            driver.findElement(By.cssSelector("input[name='year']")).sendKeys("2015");
            driver.findElement(By.cssSelector("input[name='author']")).sendKeys("Joshua F. Speed");
            driver.findElement(By.cssSelector("textarea[id=description]")).sendKeys("Book about Abraham Lincoln's favourite cakes");
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            assertTrue(driver.findElement(By.cssSelector("[class='toast-message']")).isDisplayed());

            BrowserUtility.waitFor(5);

            driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
            driver.findElement(By.xpath("//a[@class='dropdown-item']")).click();
        }
        /*
        Previously Used to Confirm New Book is created with Search
        BrowserUtility.waitFor(1);
        driver.findElement(By.cssSelector("input[type='search']")).sendKeys("Joshua F. Speed");
        BrowserUtility.waitFor(1);


            List<WebElement> bookList = driver.findElements(By.xpath("//tbody/tr/td[3]"));
            System.out.println("bookList.size() = " + bookList.size());
            for (WebElement eachElement : bookList) {
                if (eachElement.getText().equals(bookName)) {
                    assertEquals(bookName, eachElement.getText());
                    break;
                }
            }
        */

    }
}
