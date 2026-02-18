package testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginCsv {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Wait for elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open SauceDemo website
        driver.get("https://www.saucedemo.com/");
    }

    @Test(dataProvider = "csvData")
    public void loginTest(String username, String password) {

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        System.out.println("Login attempted with: " + username);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "csvData")
    public Object[][] getCSVData() throws Exception {

        return CSV.getCSVData("C:/Users/pc/Downloads/wipro nga_files/LoginCsv.csv");
    }
}
