package Hooksstep;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HooksDemoSteps {

    WebDriver driver = null;

    // General @Before hook to initialize the WebDriver for all scenarios
    @Before(order=1)
    public void browser_is_open() {
        System.out.println("Browser is open");

        // Initialize WebDriver before each scenario
        if (driver == null) {
            String projectPath = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver.exe");
            
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        }
    }

    @Before(order=0)
    public void setup2() {
        System.out.println("   I am inside setup2 \n");
    }

    @After(order=1)
    public void teardown() {
        System.out.println("   I am inside teardown");
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;  // Reset driver to null after closing
        }
    }

    @After(order=2)
    public void teardown2() {
        System.out.println("  I am inside teardown2 \n");
    }

    @BeforeStep
    public void beforeSteps() {
        System.out.println("  I am inside beforeSteps ----");
    }

    @AfterStep
    public void afterSteps() {
        System.out.println("  I am inside afterSteps ====");
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        // Ensure WebDriver is initialized
        if (driver != null) {
            driver.get("https://example.com/login");
        } else {
            throw new RuntimeException("WebDriver is not initialized.");
        }
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        // Your logic for entering username and password
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        // Your logic for clicking the login button
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        // Logic to validate home page navigation
    }
}
