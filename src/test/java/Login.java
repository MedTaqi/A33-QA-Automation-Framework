import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends BaseTest{
@Test
    public void loginValidCredentials(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage= new HomePage(driver);

    loginPage.logIn();
    Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
   }

}
