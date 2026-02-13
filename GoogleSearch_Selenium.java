package Selenium_Webdriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class GoogleSearch_Selenium {

    public static void main(String[] args) {
WebDriver driver = new ChromeDriver();

	        try {
	            
	            driver.manage().window().maximize();
	            driver.get("https://www.google.com");

	            
	            driver.findElement(By.name("q"))
	                  .sendKeys("selenium official website" + Keys.ENTER);

	            Thread.sleep(3000); 

	            
	            driver.findElement(By.xpath("//h3[contains(text(),'Selenium')]")).click();

	            Thread.sleep(3000); 
	            
	            Actions actions = new Actions(driver);
	            actions.sendKeys(Keys.PAGE_DOWN).perform();
	            Thread.sleep(2000);

	            actions.sendKeys(Keys.PAGE_DOWN).perform();
	            Thread.sleep(2000);

	            actions.sendKeys(Keys.PAGE_UP).perform();
	            Thread.sleep(2000);

	            System.out.println("Search, navigation, and scrolling completed");

	        } catch (Exception e) {
	            System.out.println("Exception occurred: " + e.getMessage());
	        } finally {
	            driver.quit();
	        }
	    }
	}
