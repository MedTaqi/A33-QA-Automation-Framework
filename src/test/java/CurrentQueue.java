import Pages.CurrentQueuePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CurrentQueue extends BaseTest{
    public void login(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage =new HomePage(driver);

        loginPage.LogIn();
        Assert.assertTrue(homePage.successLogin());
    }
    public void songsDisplayedOnCurrentQueue(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage =new HomePage(driver);
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(driver);

        loginPage.LogIn();
        homePage.PlayASong();
        homePage.clickCurrentQueue();
        Assert.assertTrue(currentQueuePage.VerifySongsAdded());
    }
    public void countIsShown(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage =new HomePage(driver);
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(driver);

        loginPage.LogIn();
        homePage.PlayASong();
        homePage.clickCurrentQueue();
        Assert.assertTrue(currentQueuePage.verifyCountAndDurationIsShown());
    }
    public void VerifyItems(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage =new HomePage(driver);
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(driver);

        loginPage.LogIn();
        homePage.PlayASong();
        homePage.clickCurrentQueue();
        Assert.assertTrue(currentQueuePage.verifyItemsAreDisplayed());

    }
}
