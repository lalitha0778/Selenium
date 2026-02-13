package Selenium_Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_Websie {
	    public static void main(String[] args) {

	        WebDriver driver = new ChromeDriver();

	        try {
	            driver.manage().window().maximize();
	            Thread.sleep(2000);

	            driver.get("https://www.google.com");
	            Thread.sleep(3000);

	            driver.findElement(By.name("q"))
	                  .sendKeys("amazon official website" + Keys.ENTER);
	            Thread.sleep(4000);

	            driver.findElement(By.xpath("//h3[contains(text(),'Amazon')]"))
	                  .click();
	            Thread.sleep(5000);

	            driver.findElement(By.id("twotabsearchtextbox"))
	                  .sendKeys("dog bed" + Keys.ENTER);
	            Thread.sleep(5000);

	            driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"))
	                  .click();
	            Thread.sleep(5000);

	            for (String window : driver.getWindowHandles()) {
	                driver.switchTo().window(window);
	            }

	            driver.findElement(By.id("add-to-cart-button"))
	                  .click();
	            Thread.sleep(5000);

	            System.out.println("Dog bed added to cart successfully");

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        } finally {
	            driver.quit();
	        }
	    }
	}
