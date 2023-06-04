package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePage{
    @FindBy(xpath = "//*[@id='playlists']//a[contains(text(),'6am')]")
    WebElement choosePlaylist1;
    @FindBy(css = "[class='del btn-delete-playlist']")
    WebElement deleteXButton;
    @FindBy(css = "[class='ok']")
    WebElement OkButton;
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public PlaylistPage selectPlaylist(){
        wait.until(ExpectedConditions.visibilityOf(choosePlaylist1)).click();
        return this;
    }
    public PlaylistPage deletePlaylist(){
        wait.until(ExpectedConditions.visibilityOf(deleteXButton)).click();
        wait.until(ExpectedConditions.visibilityOf(OkButton)).click();
        return this;
    }
    public boolean DeletedPlaylistMsg(){
        WebElement ntfMsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return ntfMsg.isDisplayed();
    }
}
