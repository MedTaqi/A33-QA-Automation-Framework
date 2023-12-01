package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By emailField = By.cssSelector ("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By SubmitBtn = By.className("[type='submit']");

    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }
    public  void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }
    public void click(){
        findElement(SubmitBtn).click();
    }
    public void logIn(){
        provideEmail("taqimed99@gmail.com");
        providePassword("Med-20115-010499@");
        click();
    }
}
