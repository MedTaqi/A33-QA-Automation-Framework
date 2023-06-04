package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
        @FindBy(css = "[type=submit]")
        static
        WebElement submitButton;
        @FindBy(css = "[type=email]")
        static
        WebElement emailField;
        @FindBy(css = "[type=password]")
        static
        WebElement passwordField;

        public LoginPage(WebDriver givenDriver) {
            super(givenDriver);
        }
        public LoginPage clickSubmitBtn() {
            submitButton.click();
            return this;
        }
        public LoginPage provideEmail(String email) {
            emailField.sendKeys(email);
            return this;
        }
        public LoginPage providePassword(String password) {
            passwordField.sendKeys(password);
            return this;
        }
        public void logIn(){
            provideEmail("taqimed99@gmail.com");
            providePassword("Med-20115-010499@");
            clickSubmitBtn();
        }
    }
