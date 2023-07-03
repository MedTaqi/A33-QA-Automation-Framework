package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public boolean successLogin(){
        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        return success.isDisplayed();
    }
    public HomePage PlayASong(){
        WebElement song =wait.until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//ol[@class='top-song-list']//span[contains(text(),'Take my Hand (ID 1696)')]")));
        actions.doubleClick(song).perform();
        return this;
    }
    public HomePage clickCurrentQueue(){
        WebElement Queue  =wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id='sidebar']//a[contains(text(),'Current Queue')]")));
        actions.doubleClick(Queue).perform();
        return this;
    }
}
