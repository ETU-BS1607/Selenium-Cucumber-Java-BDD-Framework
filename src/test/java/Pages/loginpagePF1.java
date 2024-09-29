package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpagePF1 {

    WebDriver driver;

    // Locate elements using @FindBy
    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "submit")
    WebElement loginButton;

    // Constructor
    public loginpagePF1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize elements
    }

    // Methods to interact with elements
    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() 
    {
        loginButton.click();
    }

    public boolean isLoginSuccessful() 
    {
        return driver.getPageSource().contains("Logged In Successfully");
    }
}
