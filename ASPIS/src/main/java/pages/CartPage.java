package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;

public class CartPage {

    private WebDriver driver;

    // Locators
    private By cartLink = By.id("cartur");
    private By cartItemNameCell = By.cssSelector("td:nth-child(2)");
    private By placeOrderButton = By.xpath("//button[text()='Place Order']");

    // Checkout modal fields
    private By nameField = By.id("name");
    private By countryField = By.id("country");
    private By cityField = By.id("city");
    private By creditCardField = By.id("card");
    private By monthField = By.id("month");
    private By yearField = By.id("year");
    private By purchaseButton = By.xpath("//button[text()='Purchase']");

    // Check Confirmation popup
    private By confirmationMessage = By.xpath("//h2[contains(text(),'Thank you for your purchase!')]");
    private By okButton = By.xpath("//button[text()='OK']");

    // Logout link
    private By logoutLink = By.id("logout2");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //Navigate to homepage
    public void goToHomePage() {
        driver.get("https://www.demoblaze.com/");
    }

    // Opening the cart page
    public void openCartPage() {
        driver.findElement(cartLink).click();
    }

    //Get first product name from order details
    public String getCartItemName() {
        WebElement itemCell = driver.findElement(cartItemNameCell);
        return itemCell.getText();
    }

    //Click on place order button
    public void clickPlaceOrder() {
        driver.findElement(placeOrderButton).click();
    }

    //Fill out form for order placement
    public void fillOrderFormAndPurchase(String name, String country, String city,
                                         String creditCard, String month, String year) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(creditCardField).sendKeys(creditCard);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(yearField).sendKeys(year);

        // click on purchased button
        driver.findElement(purchaseButton).click();
    }

   // Check confirm message
    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }

    //Click on corfirm message
    public void clickOkOnConfirmation() {
        driver.findElement(okButton).click();
    }

    //Click on logout button
    public void logout() {
        driver.findElement(logoutLink).click();
    }
}