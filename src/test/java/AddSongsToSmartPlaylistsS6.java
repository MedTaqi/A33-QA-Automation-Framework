import Pages.HomePage;
import Pages.LoginPage;
import Pages.PlaylistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSongsToSmartPlaylistsS6 extends BaseTest{
@Test(priority = 1)
    public void createSmartPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

    loginPage.logIn();
    homePage.createSmartPlaylist();
    homePage.enterSmartPlaylistName("6am");
    homePage.enterSongName("Ketsa - That_s a Beat");
    Assert.assertTrue(homePage.notificationMsgSmartPlaylistDisplayed());
    }

    @Test(priority = 2)
    public void EditPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

    loginPage.logIn();
    homePage.addSongWithEdit();
    homePage.chooseEdit();
    homePage.editPlaylist();
    //homePage.hoverOverToAlbums();
    homePage.doubleClick();
    //homePage.hoverOverToField();
    homePage.chooseAlbumName("Airbit");
    homePage.clickSave();
    Assert.assertTrue(homePage.updateMsgDisplayed());
    }

    @Test(priority = 3)

    public void DeletePlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

    loginPage.logIn();
    playlistPage.selectPlaylist();
    playlistPage.deletePlaylist();
    Assert.assertTrue(playlistPage.DeletedPlaylistMsg());
    }
}
