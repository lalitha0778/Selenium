package stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class LoginSteps {

    public static WebDriver driver;

    @Given("I launch the browser")
    public void i_launch_the_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("I open the login page")
    public void i_open_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter usernames")
    public void i_enter_usernames(List<String> usernames) throws InterruptedException {

        for (String username : usernames) {

            driver.findElement(By.id("user-name")).clear();
            driver.findElement(By.id("user-name")).sendKeys(username);

            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("secret_sauce");

            driver.findElement(By.id("login-button")).click();

            Thread.sleep(2000);

            System.out.println("Login attempted for: " + username);

            driver.navigate().back(); // go back to login page
        }
    }

    @Then("I close the browser")
    public void i_close_the_browser() {
        driver.quit();
    }
}