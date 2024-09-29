package projectdemo;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import Pages.loginpagePF1;  // Import LoginPage from the pages package

public class loginstep_PF {

    WebDriver driver = null;
    loginpagePF1 loginPage;  // Page object

    @Given("browser is open")
    public void browser_is_open() {
        System.out.println("Browser is open");

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @And("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("User is on login page");

        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        loginPage = new loginpagePF1(driver);  // Initialize LoginPage object using PageFactory
    }

    @When("user enters {string} and {string}")
    public void user_enters_username_and_password(String username, String password) throws InterruptedException {
        System.out.println("Input Username and Password");

        loginPage.enterUsername(username);  // Use the LoginPage method
        loginPage.enterPassword(password);  // Use the LoginPage method
        Thread.sleep(2000);  // Replace with WebDriverWait in real projects
    }

    @And("clicks on login button")
    public void clicks_on_login_button() throws InterruptedException {
        System.out.println("Clicks on login button");

        loginPage.clickLoginButton();  // Use the LoginPage method
        Thread.sleep(2000);
    }

    @Then("user is navigated to the Logged In Successfully")
    public void user_is_navigated_to_the_logged_in_successfully() {
      

        if (loginPage.isLoginSuccessful()) {  // Validate using the LoginPage method
        	System.out.println("User is navigated to the Logged In Successfully page");
            System.out.println("Login was successful");
        } else {
            System.out.println("Login failed");
        }

        // Close the browser
        driver.close();
        driver.quit();
    }
}
