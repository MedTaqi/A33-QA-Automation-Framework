package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    @FindBy(css = "img.avatar")
    WebElement userAvatarIcon;
    @FindBy(css = "[name='q']")
    WebElement searchField;
    @FindBy(css = "[role='button']")
    WebElement Xbutton;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement getUserAvatar() {
        return userAvatarIcon;
    }

    public void SearchForExSong(String songName) {
        searchField.click();
        searchField.sendKeys(songName);
    }

    public static boolean doesSongExist(String name) {
        WebElement songEx = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='searchExcerptsWrapper']//span[contains(text(),'Dark Days')]")));
        return songEx.isDisplayed();
    }

    public void SearchForExArtist(String artistName) {
        searchField.click();
        searchField.sendKeys(artistName);
    }

    public static boolean doesArtistExist() {
        WebElement artistEx = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//section[@class='artists']//*[@title='Grav']")));
        return artistEx.isDisplayed();
    }

    public void SearchForExAlbum(String albumName) {
        searchField.click();
        searchField.sendKeys(albumName);
    }

    public static boolean doesAlbumExist() {
        WebElement albumEx = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//section[@data-testid='album-excerpts']//*[@title='Arps by Chad Crouch']")));
        return albumEx.isDisplayed();
    }

    public void SearchForSongWithTrailingWhiteSpace(String songName) {
        searchField.click();
        searchField.sendKeys(songName);
    }

    public static boolean doesSongSearchedExist() {
        WebElement songTWS = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='searchExcerptsWrapper']//span[contains(text(),'Dark Days')]")));
        return songTWS.isDisplayed();
    }

    public void SearchForSongWithHeadingWhiteSpace(String songName) {
        searchField.click();
        searchField.sendKeys(songName);
    }

    public static boolean doesSongSearched2Exist() {
        WebElement songHWS = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='searchExcerptsWrapper']//span[contains(text(),'Dark Days')]")));
        return songHWS.isDisplayed();
    }

    public void SearchForNonExArtist(String artistName) {
        searchField.click();
        searchField.sendKeys(artistName);
    }

    public static boolean doesMsgNoResultsDisplayed() {
        WebElement verifyMsg = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//section[@data-testid='artist-excerpts']//p[contains(text(),'no results')]")));
        return verifyMsg.isDisplayed();
    }

    public void SearchForSongInCaseSensitive(String songName) {
        searchField.click();
        searchField.sendKeys(songName);
    }

    public static boolean doesSongExistInCaseSensitive() {
        WebElement songExInCaseSensitive = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='searchExcerptsWrapper']//span[contains(text(),'Dark Days')]")));
        return songExInCaseSensitive.isDisplayed();
    }

    public void clearSearchPageWithDeleteKey() {
        searchField.click();
        searchField.sendKeys(Keys.DELETE);
    }

    public static boolean isSearchPageEmpty() {
        WebElement EmptySearchPageVerification = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='searchExcerptsWrapper']//*[contains(text(),'Find songs, artists, and albums,')]")));
        return EmptySearchPageVerification.isDisplayed();
    }

    public void clearSearchQueryWithDeleteKey(String songName) {
        searchField.click();
        searchField.sendKeys(songName);
        searchField.sendKeys(Keys.DELETE);
    }

    public static boolean isSearchQueryEmpty() {
        WebElement EmptySearchQueryVerification = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='searchForm']//input['not(text())']")));
        return EmptySearchQueryVerification.isDisplayed();
    }

    public WebElement clearSearchQueryWithXButton(String songName) {
        searchField.click();
        searchField.sendKeys(songName);
        actions.moveToElement(Xbutton).perform();
        return Xbutton;
    }

    public static boolean isSearchQueryEmpty1() {
        WebElement EmptySearchQueryVerification = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='searchForm']//input['not(text())']")));
        return EmptySearchQueryVerification.isDisplayed();
    }
}