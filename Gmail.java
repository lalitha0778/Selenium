package testing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Gmail {
    WebDriver driver;
    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/");
    }

    @Test
    public void gmailLoginTest() throws InterruptedException {
        WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys("lalip8005@gmail.com");

        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.name("Passwd"));
        password.sendKeys("Lalitha@9");

        driver.findElement(By.id("passwordNext")).click();
        Thread.sleep(5000);

        driver.get("https://mail.google.com/mail/u/0/#inbox");
        System.out.println("Inbox Opened Successfully");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
