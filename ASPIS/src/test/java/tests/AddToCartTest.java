package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Addtocart;

import java.time.Duration;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartFlow() throws InterruptedException {

        // 1. Navigate to website
        driver.get("https://www.demoblaze.com/");

        // 2. Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tejassurani5@gmail.com", "Tejas@2025");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

        // 3. Select Product
        Addtocart addtocartPage = new Addtocart(driver);
        addtocartPage.selectSamsungGalaxy();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-success btn-lg']")));

        // 4. Add to Cart
        addtocartPage.clickAddToCart();
        wait.until(ExpectedConditions.alertIsPresent());

        // 5. Click for aleart
        String alertMsg = addtocartPage.acceptAlert();

        // 6. Verify the alert message
        System.out.println("Alert says: " + alertMsg);
        Assert.assertTrue(alertMsg.contains("Product added"), "Expected alert to mention 'Product added'");
    }
}