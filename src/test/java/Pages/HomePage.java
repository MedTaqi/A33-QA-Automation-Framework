package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{
    @FindBy(css = "img.avatar")
    WebElement userAvatarIcon;
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
        driver= givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public WebElement getUserAvatar(){
        return userAvatarIcon;
    }
}