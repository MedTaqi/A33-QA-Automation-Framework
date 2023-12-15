import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public class BaseTest {
public WebDriver driver;
public String url=null;
public Actions actions;
public WebDriverWait wait;
    By provideEmail= By.cssSelector("[type='email']");
    By providePassword= By.cssSelector("[type='password']");
    By clickBtn = By.cssSelector("[type='click']");
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser( String BaseURL){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(opts);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        actions = new Actions(driver);
        url=BaseURL;
        driver.get(url);
    }
    public void provideEmail(String email){
        driver.findElement(provideEmail).sendKeys(email);
    }
    public void providePassword(String password){
        driver.findElement(providePassword).sendKeys(password);
    }
    public void click(){
        driver.findElement(clickBtn).click();
    }


    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }



}
