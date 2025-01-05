package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class LoginSteps {
    
    WebDriver driver = new ChromeDriver();  // Create WebDriver instance

    // Step 1: Given the user is on the login page
    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        // Launching the Chrome browser and opening the login page
        //System.setProperty("webdriver.chrome.driver", "path_to_your_chromedriver");  // Set path to ChromeDriver
    	System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Selenium\\SeleniumJava\\Driver\\chromedriver.exe");
    	driver.get("http://testphp.vulnweb.com/login.php");  // Replace with your login page URL
        driver.manage().window().maximize();  // Maximize the browser window
    }

    // Step 2: When the user enters a valid username and password
    @When("the user enters a valid username and password")
    public void userEntersValidCredentials() {
        // Enter username
        driver.findElement(By.name("uname")).sendKeys("test");
        // Enter password
        driver.findElement(By.name("pass")).sendKeys("test");
        // Click login button
        driver.findElement(By.xpath("//input[@value='login']")).click();
    }

    // Step 3: Then the user should be logged in successfully
    @Then("the user should be logged in successfully")
    public void userShouldBeLoggedIn() {
        // Verify login success (e.g., check if the user is redirected to the dashboard)
        assertTrue(driver.getTitle().contains("user info"));  // Replace with actual page title or element
    }
    
    // Step 4: When the user enters an invalid username and password
    @When("the user enters an invalid username and password")
    public void userEntersInvalidCredentials() {
        // Enter invalid username
    	driver.findElement(By.name("uname")).sendKeys("test22");  // Replace with actual element locator
        // Enter invalid password
    	driver.findElement(By.name("pass")).sendKeys("invalid33");  // Replace with actual element locator
        // Click login button
    	driver.findElement(By.xpath("//input[@value='login']")).click();  // Replace with actual element locator
    }

    // Step 5: Then the user should see an error message (invalid login)
    @Then("the user should see an error message")
    public void userShouldSeeErrorMessage() {
    	// Verify login failure (e.g., check if the user is still in login page)
        assertTrue(driver.getTitle().contains("login page"));  // Replace with actual page title or element
    }

    // Additional step to close the browser after the test
    //@Then("close the browser")
    @After
    public void closeBrowser() {
        driver.quit();  // Close the browser after test completion
    }
}

