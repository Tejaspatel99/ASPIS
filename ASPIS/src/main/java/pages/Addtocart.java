package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Addtocart {

    private WebDriver driver;

    // Locators
    private By productSamsung = By.xpath("//a[normalize-space()='Samsung galaxy s6']");
    private By addToCartBtn = By.xpath("//a[@class='btn btn-success btn-lg']");

    // Constructor
    public Addtocart(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void selectSamsungGalaxy() {
        driver.findElement(productSamsung).click();
    }

    public void clickAddToCart() {
        driver.findElement(addToCartBtn).click();
    }

    // Handling the JavaScript alert after adding to cart
    public String acceptAlert() {
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        return alertMessage;
    }
}
