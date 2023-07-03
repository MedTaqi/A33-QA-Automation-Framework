package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CurrentQueuePage extends BasePage{
    public CurrentQueuePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public boolean VerifySongsAdded(){
       WebElement Queue = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='queueWrapper']//td[@class='track-number text-secondary']")));
        return Queue.isDisplayed();
    }
    public boolean verifyCountAndDurationIsShown(){
        WebElement count = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='queueWrapper']//span[@data-test='list-meta']")));
        return count.isDisplayed();
    }
    public boolean verifyItemsAreDisplayed(){
        WebElement  items= wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='queueWrapper']//th[contains(text(),'ID')]")));
        return items.isDisplayed();
    }

}
