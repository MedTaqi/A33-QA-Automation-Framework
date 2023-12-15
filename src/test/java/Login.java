import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Login extends BaseTest{
    @Test
    public void loginValidCred(){
        provideEmail("taqimed99@gmail.com");
        providePassword("Med-20115-010499@");
        click();
    }

}
