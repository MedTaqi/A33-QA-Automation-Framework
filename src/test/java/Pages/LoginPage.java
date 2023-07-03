package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    @FindBy(css = "[type='email']")
    WebElement EmailField;
    @FindBy(css = "[type='password']")
    WebElement PasswordField;
    @FindBy(css = "[type='submit']")
    WebElement ClickSubmit;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage provideEmail(String email){
    EmailField.sendKeys(email);
    return this;
    }
    public LoginPage ProvidePassword (String password){
        PasswordField.sendKeys(password);
        return this;
    }
    public LoginPage SubmitBtn(){
        ClickSubmit.click();
        return this;
    }
    public LoginPage LogIn(){
        provideEmail("taqimed99@gmail.com");
        ProvidePassword("Med-20115-010499@");
        SubmitBtn();
        return this;
    }
}
