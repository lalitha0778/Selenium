package Selenium_Webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class Selinum_Website {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.selenium.dev");

            Actions actions = new Actions(driver);

            // Scroll Down
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(2000);

            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(2000);

            // Scroll Up
            actions.sendKeys(Keys.PAGE_UP).perform();
            Thread.sleep(2000);

            System.out.println("Scrolling using keyboard completed");

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
