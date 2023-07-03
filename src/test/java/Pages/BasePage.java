package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriverWait wait;
    WebDriver driver;
    Actions actions;


    public BasePage(WebDriver givenDriver){
        driver=givenDriver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(4));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);

    }
    public void click(By Locator){
        wait.until(ExpectedConditions.elementToBeClickable(Locator));
    }
    public WebElement findElement(By Locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
    }

    public void contextClick(By Locator){
        actions.contextClick(findElement(Locator)).perform();
    }
    public void doubleClick(By Locator){
        actions.doubleClick(findElement(Locator)).perform();
    }
    public void hoverOver(By Locator){
        actions.moveToElement(findElement(Locator)).perform();
    }
}
