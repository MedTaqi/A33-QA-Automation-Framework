import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
   public void loginWithValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage  = new HomePage(driver);
        loginPage.logIn();
    }
}
