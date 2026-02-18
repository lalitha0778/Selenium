package testing;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
public class AmazonWebsite_Assign {
    WebDriver driver;
    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
    }
    @Test
    public void completeAmazonWebsite() {

        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).sendKeys("your_email@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("your_password");
        driver.findElement(By.id("signInSubmit")).click();

        driver.findElement(By.linkText("Electronics")).click();

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();

        driver.findElement(By.cssSelector(".s-main-slot .s-result-item h2 a")).click();

        String mainWindow = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
            }
        }

        driver.findElement(By.id("add-to-cart-button")).click();

        driver.findElement(By.id("nav-cart")).click();
        driver.findElement(By.name("proceedToRetailCheckout")).click();

        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.linkText("Sign Out")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public void finishExecution() {
        System.out.println("Amazon Full Flow Completed");
    }
}

