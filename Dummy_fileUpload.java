package Selenium_Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dummy_fileUpload {

	    public static void main(String[] args) {

	        WebDriver driver = new ChromeDriver();

	        try {
	            driver.manage().window().maximize();
	            Thread.sleep(2000);

	            driver.get("https://the-internet.herokuapp.com/upload");
	            Thread.sleep(2000);

	            driver.findElement(By.id("file-upload"))
	                  .sendKeys("C:\\Users\\pc\\Downloads\\Lalitha_resume.pdf");

	            Thread.sleep(2000);

	            driver.findElement(By.id("file-submit"))
	                  .click();

	            Thread.sleep(3000);

	            String text = driver.findElement(By.tagName("h3")).getText();
	            System.out.println(text);

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        } finally {
	            driver.quit();
	        }
	    }
	}

