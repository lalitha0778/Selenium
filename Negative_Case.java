package Selenium_Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Negative_Case {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	try {
	            driver.manage().window().maximize();
	            driver.get("https://www.saucedemo.com/");

	            driver.findElement(By.id("user-name"))
	                  .sendKeys("standard_user");

	            driver.findElement(By.id("password"))
	                  .sendKeys("Lalitha@9");

	            driver.findElement(By.id("login-button"))
	                  .click();

	            Thread.sleep(2000);

	            String errorMessage = driver
	                    .findElement(By.cssSelector("h3[data-test='error']"))
	                    .getText();

	            System.out.println("Login Error" + errorMessage);

	        } catch (Exception e) {
	            System.out.println("Exception: " + e.getMessage());
	        } finally {
	            driver.quit();
	        }
	    }
	}
