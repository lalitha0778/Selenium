package testing;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Annotation_Example {
    WebDriver driver;
    @BeforeClass
    public void setupClass() {
        System.out.println("BeforeClass - Setup ChromeDriver");
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setup() {
        System.out.println("BeforeMethod - Launch Browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openGoogle() {
        driver.get("https://www.google.com");
        System.out.println("Test - Opened Google");
    }
    @Test
    public void openBing() {
        driver.get("https://www.bing.com");
        System.out.println("Test - Opened Bing");
    }
    @AfterMethod
    public void tearDown() {
        System.out.println("AfterMethod - Close Browser");
        driver.quit();
    }
    @AfterClass
    public void tearDownClass() {
        System.out.println("AfterClass - Cleanup");
    }
}

