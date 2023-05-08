import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(enabled = true, priority = 1)
    public void UserCanSearchForExSong() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.logIn();
        homePage.SearchForExSong("Dark Days");
        Assert.assertTrue(homePage.doesSongExist("Dark Days"));
    }

    @Test(enabled = true, priority = 2)
    public void UserCanSearchForExArtist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.SearchForExArtist("Grav");
        Assert.assertTrue(homePage.doesArtistExist());
    }

    @Test(enabled = true, priority = 3)
    public void UserCanSearchForExAlbum() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.SearchForExAlbum("arps");
        Assert.assertTrue(homePage.doesAlbumExist());
    }

    @Test(enabled = true, priority = 4, description = "Verify search field ignores trailing white space")
    public void searchForSongUsingTrailingWhiteSpace() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.SearchForSongWithTrailingWhiteSpace("Dark Days  ");
        Assert.assertTrue(homePage.doesSongSearchedExist());
    }

    @Test(enabled = true, priority = 5, description = "Verify search field ignores heading white space")
    public void searchForSongUsingHeadingWhiteSpace() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.SearchForSongWithHeadingWhiteSpace("  Dark Days");
        Assert.assertTrue(homePage.doesSongSearched2Exist());
    }

    @Test(enabled = true, priority = 6, description = "Verify empty list with message'no results'if searching for non-existing artist")
    public void searchingForNonExArtistWithMsgNoResults() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.SearchForNonExArtist("Sami Yusuf");
        Assert.assertTrue(homePage.doesMsgNoResultsDisplayed());
    }

    @Test(enabled = true, priority = 7, description = " verify the search in case sensitive")
    public void verifyTheSearchInCaseSensitive() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.SearchForSongInCaseSensitive("DARK days");
        Assert.assertTrue(homePage.doesSongExistInCaseSensitive());
    }

    @Test(enabled = true, priority = 8, description = "user can clear the query in the search field and in the search page in each section using Delete Key")
    public void clearSearchQueryUsingDeleteKey() {
        LoginPage loginPage = new LoginPage(driver);HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.clearSearchQueryWithDeleteKey("Dark Days");
        Assert.assertTrue(homePage.isSearchQueryEmpty());
      // Assert.assertTrue(homePage.isSearchPageEmpty());
   }
   @Test(enabled = true)
    public void clearSearchQueryUsingXButton() {
        LoginPage loginPage = new LoginPage(driver);HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.clearSearchQueryWithDeleteKey("Dark Days");
        Assert.assertTrue(homePage.isSearchQueryEmpty1());
        // Assert.assertTrue(homePage.isSearchPageEmpty());
    }
}
