package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//div[@class='error-message']");
    private By logoutButton = By.xpath("//button[text()='Logout']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String userName) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(userName);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public HomePage login(String userName, String pass) {
        enterUsername(userName);
        enterPassword(pass);
        clickLogin();
        return new HomePage(driver);
    }

    public void invalidLogin(String userName, String pass) {
        enterUsername(userName);
        enterPassword(pass);
        clickLogin();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }
}
