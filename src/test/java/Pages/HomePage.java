package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(css = "img.avatar")
    WebElement userAvtarIcon;
    @FindBy(css = "[data-testid='sidebar-create-playlist-btn']")
    WebElement playlistIcon;
    @FindBy(css = "[data-testid='playlist-context-menu-create-smart']")
    WebElement smartPlaylist;
    @FindBy(xpath = "//*[@id='mainWrapper']//input[@name='name']")
    WebElement nameField;
    @FindBy(xpath = "//*[@id='mainWrapper']//input[@name='value[]']")
    WebElement  titleField;
    @FindBy(xpath = "//*[@id='mainWrapper']//*[contains(text(),'Save')]")
    WebElement submitBtn;
    @FindBy(xpath = "//*[@id='playlists']//a[contains(text(),'6am')]")
    WebElement choosePlaylist;
    @FindBy(xpath = "//*[@id='playlists']//li[contains(text(),'Edit')]")
    WebElement editPlaylist;
    @FindBy(css = "[name='model[]']")
    WebElement clickOnTitle;
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public boolean getUserAvatar(){
        return userAvtarIcon.isDisplayed();
    }
    public HomePage createSmartPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(playlistIcon)).click();
        wait.until(ExpectedConditions.visibilityOf(smartPlaylist)).click();
        return this;
    }
    public HomePage enterSmartPlaylistName(String SmartPlaylistName) {
            wait.until(ExpectedConditions.visibilityOf(nameField)).sendKeys(SmartPlaylistName);
            wait.until(ExpectedConditions.visibilityOf(titleField)).click();
            return this;
    }
    public HomePage enterSongName(String SongName) {
        titleField.sendKeys(SongName);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        return this;
    }
    public boolean notificationMsgSmartPlaylistDisplayed(){
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.isDisplayed();
        }
    public HomePage addSongWithEdit(){
        wait.until(ExpectedConditions.visibilityOf(choosePlaylist));
        actions.contextClick(choosePlaylist).perform();
        return this;
    }
    public HomePage chooseEdit(){
        wait.until(ExpectedConditions.visibilityOf(editPlaylist)).click();
        return this;
    }
    public HomePage editPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(clickOnTitle)).click();
        return this;
    }
    public HomePage hoverOverToAlbums(){
        WebElement albums = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div[1]/div[2]/select[1]/option[2]")));
        actions.moveToElement(albums).click().perform();
        return this;
    }
    public HomePage chooseAlbumName(String Album){
        wait.until(ExpectedConditions.visibilityOf(titleField)).click();
        titleField.sendKeys(Album);
        return this;
    }
    public HomePage clickSave(){
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        return this;
    }
    public boolean updateMsgDisplayed(){
        WebElement notifMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notifMsg.isDisplayed();
    }
}

