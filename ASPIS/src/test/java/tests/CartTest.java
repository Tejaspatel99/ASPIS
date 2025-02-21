package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Addtocart;
import pages.CartPage;

import java.time.Duration;

public class CartTest extends BaseTest {

    @Test
    public void placeOrderFlow() throws InterruptedException {

        //Navigate to website
        driver.get("https://www.demoblaze.com/");

        //Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tejassurani5@gmail.com", "Tejas@2025");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

        //Add to Cart
        Addtocart addtocartPage = new Addtocart(driver);
        addtocartPage.selectSamsungGalaxy();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-success btn-lg']")));

        addtocartPage.clickAddToCart();
        wait.until(ExpectedConditions.alertIsPresent());

        //Accept the alert pop up
        addtocartPage.acceptAlert();

        //Open Cart and verify item
        CartPage cartPage = new CartPage(driver);
        cartPage.openCartPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td:nth-child(2)")));

        String actualItemName = cartPage.getCartItemName();
        System.out.println("Item in cart: " + actualItemName);
        Assert.assertEquals(actualItemName, "Samsung galaxy s6", "Item in cart mismatch!");

        //Place Order
        cartPage.clickPlaceOrder();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));

        //Fill Order Form and Purchase
        cartPage.fillOrderFormAndPurchase("Tej", "Canada", "Toronto",
                "4242-4242-4242-4242", "11", "2025");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")));

        //Check Confirmation messsage in pop up
        String message = cartPage.getConfirmationMessage();
        System.out.println("Confirmation: " + message);
        Assert.assertTrue(message.contains("Thank you for your purchase!"), "Expected 'Thank you' message.");

        //Click OK and Logout
        cartPage.clickOkOnConfirmation();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")));
        cartPage.logout();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));

    }
}