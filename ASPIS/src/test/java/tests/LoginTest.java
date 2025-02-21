package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() throws InterruptedException {

        // Navigate to website
        driver.get("https://www.demoblaze.com/");

        // Instantiate object
        LoginPage loginPage = new LoginPage(driver);

        // Perform login
        loginPage.login("tejassurani5@gmail.com", "Tejas@2025");

        //Assert Login successful or not
        String welcomeText = driver.findElement(By.xpath("//a[@id='nameofuser']")).getText();
        Assert.assertTrue(welcomeText.contains("Welcome tejassurani5@gmail.com"), "Username not found in welcome text!");
    }
}