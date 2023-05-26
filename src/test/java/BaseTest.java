import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.sql.Driver;
import java.time.Duration;


public class BaseTest {
    static WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    String url = null;

    @BeforeSuite
   // static void setupClass() {
       // WebDriverManager.chromedriver().setup();
   // }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl) throws MalformedURLException {
       // ChromeOptions ops = new ChromeOptions();
        //ops.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
        //driver = new ChromeDriver(ops);
        driver = pickBrowser(System.getProperty("browser"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseUrl;
        driver.get(url);
    }

    private static WebDriver  pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps  =  new DesiredCapabilities();
        String gridUrl="http://192.168.1.150:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "grid-firefox":
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-safari":
                caps.setCapability("browserName","safari");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions  ops = new ChromeOptions();
                ops.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(ops);
        }
    }

    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }
}
