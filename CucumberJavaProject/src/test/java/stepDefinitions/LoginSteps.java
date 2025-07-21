package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class LoginSteps {

    WebDriver driver;

    // Step 1: Given the user is on the login page
    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        WebDriverManager.chromedriver().setup();

        // ✅ Added headless Chrome support
        ChromeOptions options = new ChromeOptions();
        if (Boolean.getBoolean("headless")) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);
        driver.get("http://testphp.vulnweb.com/login.php");
        driver.manage().window().maximize();
    }

    // Step 2: When the user enters a valid username and password
    @When("the user enters a valid username and password")
    public void userEntersValidCredentials() {
        driver.findElement(By.name("uname")).sendKeys("test");
        driver.findElement(By.name("pass")).sendKeys("test");
        waitSec(2);
        driver.findElement(By.xpath("//input[@value='login']")).click();
        waitSec(2);
    }

    // Step 3: Then the user should be logged in successfully
    @Then("the user should be logged in successfully")
    public void userShouldBeLoggedIn() {
        assertTrue(driver.getTitle().contains("user info"));
    }

    // Step 4: When the user enters an invalid username and password
    @When("the user enters an invalid username and password")
    public void userEntersInvalidCredentials() {
        driver.findElement(By.name("uname")).sendKeys("test22");
        driver.findElement(By.name("pass")).sendKeys("invalid33");
        driver.findElement(By.xpath("//input[@value='login']")).click();
        waitSec(1);
    }

    // Step 5: Then the user should see an error message (invalid login)
    @Then("the user should see an error message")
    public void userShouldSeeErrorMessage() {
        assertTrue(driver.getTitle().contains("login page"));
    }

    @When("the user updates their email to {string}")
    public void userUpdatesEmail(String newEmail) {
        driver.findElement(By.name("uemail")).clear();
        driver.findElement(By.name("uemail")).sendKeys(newEmail);
        driver.findElement(By.name("update")).click();
        waitSec(1);
    }

    @Then("the user information should be updated")
    public void userInfoShouldBeUpdated() {
        assertEquals("newemail@example.com", driver.findElement(By.name("uemail")).getAttribute("value"));
    }

    @Then("the user should see {string} on the home page")
    public void userShouldSeeCartCount(String expectedText) {
        List<WebElement> allStories = driver.findElements(By.cssSelector("div.story p"));
        WebElement cartMessage = allStories.get(allStories.size() - 1);
        String actualText = cartMessage.getText();
        waitSec(2);
        assertTrue(actualText.contains(expectedText));
    }

    @When("the user clicks logout")
    public void userClicksLogout() {
        driver.findElement(By.linkText("Logout test")).click();
    }

    @Then("the user should be redirected to the login page")
    public void userShouldBeRedirectedToLoginPage() {
        assertTrue(driver.getTitle().toLowerCase().contains("logout"));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    void waitSec(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Step 1: Given the user is on the login page
    // Duplicate step definition for: Given the user is on the login page
    // This method launches the Chrome browser and opens the login page using a hardcoded driver path.
    // @Given("the user is on the login page")
    //test comment
    //public void userIsOnLoginPage() {
        //System.setProperty("webdriver.chrome.driver", "path_to_your_chromedriver");  // Set path to ChromeDriver
        //System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Selenium\\SeleniumJava\\Driver\\chromedriver.exe");
        //driver.get("http://testphp.vulnweb.com/login.php");  // Replace with your login page URL
        //driver.manage().window().maximize();
    //}
}
