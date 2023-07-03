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
}
