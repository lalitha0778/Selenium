package Selenium_Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Add_To_Cart {
	    public static void main(String[] args) {

	        WebDriver driver = new ChromeDriver();

	        try {
	            driver.manage().window().maximize();
	            driver.get("https://www.saucedemo.com/");

	            driver.findElement(By.id("user-name"))
	                  .sendKeys("standard_user");

	            driver.findElement(By.id("password"))
	                  .sendKeys("secret_sauce");

	            driver.findElement(By.id("login-button"))
	                  .click();

	            Thread.sleep(3000);

	            driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
	                  .click();

	            Thread.sleep(2000);

	            driver.findElement(By.className("shopping_cart_link"))
	                  .click();

	            System.out.println("Product added to cart successfully");

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        } finally {
	            driver.quit();
	        }
	    }
	}

