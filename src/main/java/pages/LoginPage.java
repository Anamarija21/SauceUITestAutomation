
package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

private WebDriver driver;    
private final By usernameFieldLocator = By.id("user-name");
private final By passwordFieldLocator = By.id("password");
private final By loginButtonLocator = By.id("login-button");
private final By UsernameMessageLocator = By.xpath("//*[@id=\"login_button_container\"]/div/form/h3");
private final By PasswordMessageLocator = By.xpath("//*[@id=\"login_button_container\"]/div/form/h3");

public LoginPage(WebDriver  driver){
this.driver = driver;
}

public void enterUsernameOfValidUser(){
    driver.findElement(usernameFieldLocator).sendKeys("standard_user"); 
}

public void enterUsernameOfNonExistingUser(){
driver.findElement(usernameFieldLocator).sendKeys(Helper.getRandomUsername());
}

public void enterPasswordOfValidUser(){
    driver.findElement(passwordFieldLocator).sendKeys("secret_sauce");
}

public void enterPasswordOfNonExistingUser(){
    driver.findElement(passwordFieldLocator).sendKeys("ana");
}
public void clickLoginButton(){
    driver.findElement(loginButtonLocator).click();
}

public String getUsernameMessageText(){
   return driver.findElement(UsernameMessageLocator).getText();
}

public String getPasswordMessageText(){
   return driver.findElement(PasswordMessageLocator).getText();
}

}
