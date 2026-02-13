package Selenium_Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Incorret_User {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	try {
	            driver.manage().window().maximize();
	            driver.get("https://www.saucedemo.com/");

	            driver.findElement(By.id("user-name"))
	                  .sendKeys("incorrect_user");

	            driver.findElement(By.id("password"))
	                  .sendKeys("secret_sauce");

	            driver.findElement(By.id("login-button"))
	                  .click();

	            Thread.sleep(2000);

	            String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
	            System.out.println("Error Message: " + errorMessage);

	            if (errorMessage.contains("Username and password do not match")) {
	                System.out.println("Test Passed: Incorrect username handled correctly");
	            } else {
	                System.out.println("Test Failed");
	            }

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        } finally {
	            driver.quit();
	        }
	    }
	}
