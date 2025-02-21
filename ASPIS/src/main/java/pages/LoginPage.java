package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    // 1. Locators
    private By loginLink = By.id("login2");
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By loginButton = By.xpath("//button[normalize-space()='Log in']");

    // 2. Webdriver reference
    private WebDriver driver;

    // 3. Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 4. Page methods
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void EnterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void EnterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }


    public void login(String username, String password) {
        clickLoginLink();
        EnterUsername(username);
        EnterPassword(password);
        clickLoginButton();
    }
}
