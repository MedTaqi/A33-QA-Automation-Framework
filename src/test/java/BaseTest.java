import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public class BaseTest {
WebDriver driver;
WebDriverWait wait;
String Url=null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(@Optional String BaseURL){
        ChromeOptions ops=new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(ops);
        wait=new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Url=BaseURL;
        driver.get(Url);
    }
    @AfterMethod
    public void QuitBrowser(){
        driver.quit();
    }

}
